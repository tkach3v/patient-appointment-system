package com.tkachev.patientappointmentsystem.services;

import com.tkachev.patientappointmentsystem.dto.models.appointments.AppointmentResponse;
import com.tkachev.patientappointmentsystem.dto.models.appointments.UpdateAppointmentRequest;
import com.tkachev.patientappointmentsystem.soap.gen.CreateTimetableRequest;

import java.sql.Date;
import java.util.List;

public interface AppointmentService {

    void createAppointments(CreateTimetableRequest dto);

    List<AppointmentResponse> getAvailableAppointments(Date date, Long doctorId);

    List<AppointmentResponse> getAppointmentsByPatient(Long patientId);

    AppointmentResponse reserveAppointment(UpdateAppointmentRequest dto);
}
