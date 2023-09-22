package com.stackroute.BookingService.Controller;

import com.stackroute.BookingService.Model.Appointment;
import com.stackroute.BookingService.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/create")
    public ResponseEntity createAppointmentService(@RequestBody Appointment appointmentDetails) {
        try {
            return new ResponseEntity<>(appointmentService.createAppointmentService(appointmentDetails), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/details")
    public ResponseEntity<?> getBarberAllRecords() {
        try {
            return new ResponseEntity<>(appointmentService.getAllAppointmentServices(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/details/{id}")
    public ResponseEntity getAppointmentDetailsForBarber(@PathVariable long id) {
        try {
            return new ResponseEntity<>(appointmentService.getAppointmentOfBarber(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/barber/availability")
    public ResponseEntity checkBarberAvailability(@RequestBody Appointment appointmentDetails) {
        try {
            return new ResponseEntity<>(appointmentService.getBarberAvailability(appointmentDetails), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}










