package com.tkachev.patientappointmentsystem.rest;

import com.tkachev.patientappointmentsystem.dto.models.appointments.AppointmentResponse;
import com.tkachev.patientappointmentsystem.dto.models.appointments.UpdateAppointmentRequest;
import com.tkachev.patientappointmentsystem.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> getAvailableAppointments(@RequestParam(name = "date") Date date,
                                                                              @RequestParam(name = "doctor-id") Long doctorId) {
        return new ResponseEntity<>(appointmentService.getAvailableAppointments(date, doctorId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<AppointmentResponse> reserveAppointment(@Valid @RequestBody UpdateAppointmentRequest dto) {
        return new ResponseEntity<>(appointmentService.reserveAppointment(dto), HttpStatus.OK);
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<List<AppointmentResponse>> getAppointmentsByPatient(@PathVariable(name = "id") Long patientId) {
        return new ResponseEntity<>(appointmentService.getAppointmentsByPatient(patientId), HttpStatus.OK);
    }
}
