package com.tkachev.patientappointmentsystem.exception_handling.response;

public class ExceptionResponse {
    private String exceptionMessage;

    public ExceptionResponse() {
    }

    public ExceptionResponse(String message) {
        this.exceptionMessage = message;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
