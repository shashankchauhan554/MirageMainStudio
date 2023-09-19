package com.stackroute.SalonOwnerService.service;

import com.stackroute.SalonOwnerService.model.Salon;

public interface SalonService {
    Iterable<Salon> getAllBookings();
    Salon getBookingById(String id);
    Salon createBooking(Salon booking);
    Salon updateBooking(String id, Salon booking);
    void deleteBooking(String id);


}
