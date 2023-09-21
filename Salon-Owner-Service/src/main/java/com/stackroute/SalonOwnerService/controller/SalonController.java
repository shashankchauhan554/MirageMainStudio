package com.stackroute.SalonOwnerService.controller;

import com.stackroute.SalonOwnerService.model.Salon;
import com.stackroute.SalonOwnerService.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/salon/bookings")
public class SalonController {

    @Autowired
    private SalonService salonService;

    @GetMapping
    public Iterable<Salon> getAllBookings() {
        return salonService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Salon getBookingById(@PathVariable String id) {

        return salonService.getBookingById(id);
    }

    @PostMapping
    public Salon createBooking(@RequestBody Salon booking) {
        return salonService.createBooking(booking);
    }

    @PutMapping("/{id}")
    public Salon updateBooking(@PathVariable String id, @RequestBody Salon booking) {
        return salonService.updateBooking(id, booking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable String id) {
        salonService.deleteBooking(id);
        return ResponseEntity.ok("Booking deleted successfully");
    }
}