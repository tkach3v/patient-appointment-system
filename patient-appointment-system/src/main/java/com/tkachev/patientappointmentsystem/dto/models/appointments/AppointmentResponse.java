package com.tkachev.patientappointmentsystem.dto.models.appointments;

import com.tkachev.patientappointmentsystem.dto.models.doctors.DoctorResponse;
import com.tkachev.patientappointmentsystem.dto.models.patients.PatientResponse;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * A DTO for the {@link com.tkachev.patientappointmentsystem.entities.Appointment} entity
 */
@Data
public class AppointmentResponse implements Serializable {
    private final Long id;
    private final Date date;
    private final Time startTime;
    private final DoctorResponse doctor;
    private final PatientResponse patient;
}