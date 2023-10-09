package com.stackroute.BookingService.Service;
import com.stackroute.BookingService.Model.Appointment;
import com.stackroute.BookingService.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.*;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Appointment createAppointmentService(Appointment appointmentDetails) {
        appointmentDetails.setId(generateAppointmentId());
        return appointmentRepository.save(appointmentDetails);
    }

    @Override
    public List<Appointment> getAllAppointmentServices() {
        List<Appointment> appointmentDetailsList = appointmentRepository.findAll();
        Comparator<Appointment> comparator = Comparator.comparing(Appointment::getAppointmentDate);
        Collections.sort(appointmentDetailsList, comparator);
        return appointmentDetailsList;
    }

   


    @Override
    public List<Appointment> getAppointmentBySalonName(String salonName) {

        return appointmentRepository.findByEmail(salonName);
    }

    @Override
    public List<Appointment> getAppointmentByCustomerEmail(String customerEmail) {

        return appointmentRepository.findByCustomerEmail(customerEmail);
    }
    private long generateAppointmentId() {
        SecureRandom random = new SecureRandom();
        int num = random.nextInt(100000);
        String randomAppointmentId = String.format("%05d", num);
        return Long.valueOf(randomAppointmentId);
    }
}



