package com.tkachev.patientappointmentsystem.dto.models.doctors;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

/**
 * A DTO for the {@link com.tkachev.patientappointmentsystem.entities.Doctor} entity
 */
@Data
public class DoctorResponse implements Serializable {
    private final Long id;
    private final UUID uuid;
    private final String fullName;
    private final Date birthDate;
}