package com.tkachev.patientappointmentsystem.repositories;

import com.tkachev.patientappointmentsystem.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByDateAndDoctorId(Date date, Long doctorId);

    List<Appointment> findAllByDateAndDoctorIdAndPatientId(Date date, Long doctorId, Long patientId);

    List<Appointment> findAllByPatientId(Long patientId);

    List<Appointment> findAllByPatientUuid(UUID uuid);
}
