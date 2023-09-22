package com.stackroute.BookingService.Service;

import com.stackroute.BookingService.Model.Appointment;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface AppointmentService {
    Appointment createAppointmentService(Appointment appointmentDetails);
    List<Appointment> getAllAppointmentServices();

    boolean getBarberAvailability(Appointment appointmentDetails);
    List<Appointment> getAppointmentOfBarber(long id);
}



