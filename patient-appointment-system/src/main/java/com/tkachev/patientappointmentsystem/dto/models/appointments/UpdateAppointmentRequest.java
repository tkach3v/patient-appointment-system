package com.tkachev.patientappointmentsystem.dto.models.appointments;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link com.tkachev.patientappointmentsystem.entities.Appointment} entity
 */
@Data
public class UpdateAppointmentRequest implements Serializable {
    @NotNull
    private final Long id;
    @NotNull
    private final Long patientId;
}