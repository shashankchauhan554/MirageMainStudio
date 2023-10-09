package com.stackroute.BookingService.Service;

import com.stackroute.BookingService.Model.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AppointmentService {
    Appointment createAppointmentService(Appointment appointmentDetails);
    List<Appointment> getAllAppointmentServices();


   List <Appointment> getAppointmentBySalonName(String salonName);
}



