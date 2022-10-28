package com.tkachev.patientappointmentsystem.dto.mappers;

import com.tkachev.patientappointmentsystem.dto.models.doctors.DoctorResponse;
import com.tkachev.patientappointmentsystem.entities.Doctor;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DoctorMapper {

    DoctorResponse toDoctorResponse(Doctor doctor);
}
