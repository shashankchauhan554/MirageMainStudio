package com.stackroute.BookingService.Controller;

import com.stackroute.BookingService.Model.Appointment;
import com.stackroute.BookingService.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
@CrossOrigin (origins="http://localhost:4200")
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


    @GetMapping("/salon-name/{salonName}")
    public ResponseEntity getBySalonName(@PathVariable String salonName){

        List<Appointment> appointment= appointmentService.getAppointmentBySalonName(salonName);

        if(appointment!=null){
            return ResponseEntity.status(HttpStatus.OK).body(appointment);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Does not exist");
    }

}










