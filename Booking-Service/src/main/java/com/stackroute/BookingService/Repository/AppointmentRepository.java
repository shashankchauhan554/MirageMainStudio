package com.stackroute.BookingService.Repository;

import com.stackroute.BookingService.Model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface  AppointmentRepository extends MongoRepository<Appointment,String> {
    List<Appointment> findByBarberId(long barberId);
}









