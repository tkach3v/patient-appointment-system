package com.tkachev.patientappointmentsystem.exception_handling.exceptions;

public class AppointmentAlreadyReservedException extends RuntimeException {
    public AppointmentAlreadyReservedException(String message) {
        super(message);
    }
}
