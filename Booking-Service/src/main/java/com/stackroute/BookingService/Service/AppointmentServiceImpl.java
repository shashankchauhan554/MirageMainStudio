package com.stackroute.BookingService.Service;
import com.stackroute.BookingService.Model.Appointment;
import com.stackroute.BookingService.Service.AppointmentService;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.stackroute.BookingService.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
    public boolean getBarberAvailability(Appointment appointmentDetails) {

        String bookingDate = appointmentDetails.getAppointmentDate();
        String startTime = appointmentDetails.getStartTime();
        String endTime = appointmentDetails.getEndTime();

        Query query = new Query();
        query.addCriteria(
                new Criteria().andOperator(
                        Criteria.where("appointmentDate").is(bookingDate),
                        Criteria.where("startTime").is(startTime),
                        Criteria.where("endTime").is(endTime),
                        Criteria.where("barberId").is(appointmentDetails.getBarberId())
                )
        );

        List<Appointment> appointmentDetailsList = mongoTemplate.find(query, Appointment.class);
        if(appointmentDetailsList.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public List<Appointment> getAppointmentOfBarber(long id) {
        List<Appointment> barberAppointmentList = appointmentRepository.findByBarberId(id);
        return barberAppointmentList;
    }


    private long generateAppointmentId() {
        SecureRandom random = new SecureRandom();
        int num = random.nextInt(100000);
        String randomAppointmentId = String.format("%05d", num);
        return Long.valueOf(randomAppointmentId);
    }
}



