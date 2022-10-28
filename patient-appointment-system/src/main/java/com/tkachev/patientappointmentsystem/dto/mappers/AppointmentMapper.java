package com.tkachev.patientappointmentsystem.dto.mappers;

import com.tkachev.patientappointmentsystem.dto.models.appointments.AppointmentResponse;
import com.tkachev.patientappointmentsystem.dto.models.appointments.UpdateAppointmentRequest;
import com.tkachev.patientappointmentsystem.entities.Appointment;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring",
        uses = {PatientMapper.class, DoctorMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AppointmentMapper {

    AppointmentResponse toAppointmentResponse(Appointment appointment);

    @Mapping(source = "patientId", target = "patient.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Appointment updateAppointment(UpdateAppointmentRequest updateAppointmentRequest, @MappingTarget Appointment appointment);
}
