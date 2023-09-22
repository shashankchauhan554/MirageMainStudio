package com.stackroute.SalonOwnerService.service;


import com.stackroute.SalonOwnerService.exception.SalonIdDoesNotExistException;
import com.stackroute.SalonOwnerService.exception.SalonNameNotFoundException;
import com.stackroute.SalonOwnerService.exception.SalonOwnerIdAlreadyExistException;
import com.stackroute.SalonOwnerService.exception.SalonOwnerIdDoesNotExistException;
import com.stackroute.SalonOwnerService.model.Salon;
import com.stackroute.SalonOwnerService.model.SalonOwner;

import java.util.Optional;

public interface SalonOwnerService {
    // add new Salon Owner
    public SalonOwner addSalonOwner(SalonOwner salonOwner) throws SalonOwnerIdAlreadyExistException;
    // getting all Salon Owner
    public Iterable<SalonOwner> viewAllSalonOwner();
    //delete Salon Owner Using OwnerId
    boolean deleteSalonOwnerbyOwnerId(String ownerId) throws SalonOwnerIdDoesNotExistException;
    // update Owner Details
    public SalonOwner updateOwner(SalonOwner salonOwner) throws SalonOwnerIdDoesNotExistException;
    // fetch Owner Details using ownerId
    public Optional<SalonOwner> getOwnerByOwnerId(String ownerId);
    // add new Salon using ownerId
    SalonOwner addSalon(String ownerId, Salon salon) throws SalonOwnerIdDoesNotExistException;
    //    List<SalonOwner> getSalonOwnerByAddr(String addr);
    boolean deleteSalon(String ownerId, String salonId) throws SalonOwnerIdDoesNotExistException, SalonIdDoesNotExistException;
    public Salon getSalonByName(String ownerId, String salonName) throws SalonOwnerIdDoesNotExistException, SalonNameNotFoundException;
    public Salon getSalonByAddress(String ownerId, String salonAddress) throws SalonOwnerIdDoesNotExistException, SalonNameNotFoundException;
}

