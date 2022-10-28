package com.tkachev.patientappointmentsystem.dto.models.patients;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

/**
 * A DTO for the {@link com.tkachev.patientappointmentsystem.entities.Patient} entity
 */
@Data
public class PatientResponse implements Serializable {
    private final Long id;
    private final UUID uuid;
    private final String fullName;
    private final Date birthDate;
}