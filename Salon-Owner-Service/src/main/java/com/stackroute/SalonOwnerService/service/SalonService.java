package com.stackroute.SalonOwnerService.service;

import com.stackroute.SalonOwnerService.exception.*;
import com.stackroute.SalonOwnerService.model.Salon;
import com.stackroute.SalonOwnerService.model.Category;
import java.util.List;
import java.util.Optional;

public interface SalonService {

    // adding new Salon
    public Salon addSalon(Salon salon) throws SalonIdAlreadyExistException;

    // fetch the all salon
    public Iterable<Salon> viewAllSalons();

    //delete the Salon using SalonId
    boolean deleteSalonbySalonId(String hotelId) throws SalonIdDoesNotExistException;

    // update the salon data
    public Salon updateSalon(Salon salon) throws SalonIdDoesNotExistException;

    // getting the salon data using salonId
    public Optional<Salon> getSalonBySalonId(String salonId);

    Salon addCategory(String salonId, Category category) throws SalonIdDoesNotExistException;

    List<Salon> getSalonByLocation(String location);

    Salon getSalonByName(String name);

    boolean deleteCategory(String hotelId, String category) throws SalonIdDoesNotExistException, CategoryDoesNotExistException;

    List<Salon> getSalonBasedOnCost(int price);
}
