package com.tkachev.patientappointmentsystem.dto.mappers;

import com.tkachev.patientappointmentsystem.dto.models.patients.PatientResponse;
import com.tkachev.patientappointmentsystem.entities.Patient;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PatientMapper {

    PatientResponse toPatientResponse(Patient patient);
}
