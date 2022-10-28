package com.tkachev.patientappointmentsystem.soap;

import com.tkachev.patientappointmentsystem.services.AppointmentService;
import com.tkachev.patientappointmentsystem.soap.gen.CreateTimetableRequest;
import com.tkachev.patientappointmentsystem.soap.gen.CreateTimetableResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class TimetableEndpoint {
    private static final String NAMESPACE_URI = "http://www.tkachev.com/patientappointmentsystem/soap/gen";
    private final AppointmentService appointmentService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createTimetableRequest")
    @ResponsePayload
    public CreateTimetableResponse createTimetable(@RequestPayload CreateTimetableRequest request) {
        appointmentService.createAppointments(request);

        CreateTimetableResponse response = new CreateTimetableResponse();
        response.setMessage("Timetable has been created");

        return response;
    }
}
