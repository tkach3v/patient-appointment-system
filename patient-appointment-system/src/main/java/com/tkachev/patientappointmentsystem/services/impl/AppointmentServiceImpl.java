package com.tkachev.patientappointmentsystem.services.impl;

import com.tkachev.patientappointmentsystem.dto.mappers.AppointmentMapper;
import com.tkachev.patientappointmentsystem.dto.models.appointments.AppointmentResponse;
import com.tkachev.patientappointmentsystem.dto.models.appointments.UpdateAppointmentRequest;
import com.tkachev.patientappointmentsystem.entities.Appointment;
import com.tkachev.patientappointmentsystem.entities.Doctor;
import com.tkachev.patientappointmentsystem.entities.Patient;
import com.tkachev.patientappointmentsystem.exception_handling.exceptions.AppointmentAlreadyReservedException;
import com.tkachev.patientappointmentsystem.exception_handling.exceptions.EntityAlreadyExistsException;
import com.tkachev.patientappointmentsystem.repositories.AppointmentRepository;
import com.tkachev.patientappointmentsystem.repositories.DoctorRepository;
import com.tkachev.patientappointmentsystem.repositories.PatientRepository;
import com.tkachev.patientappointmentsystem.services.AbstractService;
import com.tkachev.patientappointmentsystem.services.AppointmentService;
import com.tkachev.patientappointmentsystem.soap.gen.CreateTimetableRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl extends AbstractService implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AppointmentMapper mapper;

    @Override
    public void createAppointments(CreateTimetableRequest dto) {
        Date date = new Date(dto.getDate().
                toGregorianCalendar().
                getTime().
                getTime());
        GregorianCalendar calendar = dto.getStartTime().toGregorianCalendar();
        int duration = dto.getDuration();
        GregorianCalendar newDay = GregorianCalendar.from(calendar.toZonedDateTime());
        newDay.add(Calendar.DATE, 1);
        newDay.set(Calendar.HOUR, 0);
        newDay.set(Calendar.MINUTE, 0);

        if (!appointmentRepository.findAllByDateAndDoctorId(date, dto.getDoctorId()).isEmpty()) {
            throw new EntityAlreadyExistsException("Timetable with this date and doctor already exists!");
        }
        Doctor doctor = doctorRepository.findById(dto.getDoctorId()).orElse(null);
        isNotNull(doctor, "Doctor", dto.getDoctorId());

        for (int i = 0; calendar.before(newDay) && i < dto.getAmount(); calendar.add(Calendar.MINUTE, duration), i++) {
            Appointment appointment = new Appointment();
            Time time = new Time(calendar.getTime().
                    getTime());

            appointment.setDate(date);
            appointment.setStartTime(time);
            appointment.setDoctor(doctor);

            appointmentRepository.save(appointment);
        }
    }

    @Override
    public List<AppointmentResponse> getAvailableAppointments(Date date, Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        isNotNull(doctor, "Doctor", doctorId);

        return appointmentRepository.findAllByDateAndDoctorIdAndPatientId(date, doctorId, null)
                .stream()
                .map(mapper::toAppointmentResponse)
                .toList();
    }

    @Override
    public AppointmentResponse reserveAppointment(UpdateAppointmentRequest dto) {
        Appointment appointment = appointmentRepository.findById(dto.getId()).orElse(null);
        isNotNull(appointment, "Appointment", dto.getId());
        Patient patient = patientRepository.findById(dto.getPatientId()).orElse(null);
        isNotNull(patient, "Patient", dto.getPatientId());

        if (appointment.getPatient() != null) {
            throw new AppointmentAlreadyReservedException("Appointment already reserved!");
        }

        List<Appointment> appointments = appointmentRepository.findAllByDateAndDoctorIdAndPatientId(appointment.getDate(), appointment.getDoctor().getId(), dto.getPatientId());
        if (!appointments.isEmpty()) {
            throw new AppointmentAlreadyReservedException("Appointment with this date and doctor already exists!");
        }

        appointment.setPatient(patient);
        appointmentRepository.save(appointment);

        return mapper.toAppointmentResponse(appointment);
    }

    @Override
    public List<AppointmentResponse> getAppointmentsByPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        isNotNull(patient, "Patient", patientId);

        return appointmentRepository.findAllByPatientId(patientId)
                .stream()
                .map(mapper::toAppointmentResponse)
                .toList();
    }
}
