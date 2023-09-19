package com.stackroute.SalonOwnerService.service.Impl;

import com.stackroute.SalonOwnerService.model.Salon;
import com.stackroute.SalonOwnerService.repository.SalonRepo;
import com.stackroute.SalonOwnerService.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalonServiceImpl implements SalonService {

    @Autowired
    private SalonRepo salonRepository;

    @Override
    public Iterable<Salon> getAllBookings() {
        return  salonRepository.findAll();
    }

    @Override
    public Salon getBookingById(String id) {

        return salonRepository.findById(id).orElse(null);
    }

    @Override
    public Salon createBooking(Salon booking) {

        return salonRepository.save(booking);
    }

    @Override
    public Salon updateBooking(String id, Salon booking) {
        // Implement update logic
        // You may want to handle updating specific fields based on the use case
        // For simplicity, this example does not include the update logic
        return salonRepository.save(booking);
    }

    @Override
    public void deleteBooking(String id) {

        salonRepository.deleteById(id);
    }
}