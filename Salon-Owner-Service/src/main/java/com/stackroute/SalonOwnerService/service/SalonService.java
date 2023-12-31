package com.stackroute.SalonOwnerService.service;

import com.stackroute.SalonOwnerService.exception.*;
import com.stackroute.SalonOwnerService.model.Salon;
import com.stackroute.SalonOwnerService.model.Slot;

import java.util.List;
import java.util.Optional;

public interface SalonService {


    public Salon addSalon(Salon salon) throws SalonIdAlreadyExistException;

    Salon addService(String ownerId, com.stackroute.SalonOwnerService.model.SalonService salonService) throws SalonOwnerIdDoesNotExistException;

    Salon addSlot(String ownerId, Slot slot) throws SalonOwnerIdDoesNotExistException;

    Iterable<Salon> viewAllSalon();
    // fetch the all salon
    Optional<Salon> viewSalonById(String ownerId) throws SalonOwnerIdDoesNotExistException;
    Optional<Salon> viewSalonByEmailId(String emailId) throws SalonOwnerIdDoesNotExistException;

    //delete the Salon using SalonId
    boolean deleteSalonbySalonId(String sid) throws SalonIdDoesNotExistException;
    boolean deleteSlotBySlotId(String ownerId, String slotId) throws SalonOwnerIdDoesNotExistException;
    boolean deleteSalonService(String ownerId, String serviceId) throws SalonOwnerIdDoesNotExistException;
    boolean editSlotBySlotId(String ownerId, String slotId, Slot updatedSlot) throws SalonOwnerIdDoesNotExistException;
    Salon editService(String ownerId, String serviceId, com.stackroute.SalonOwnerService.model.SalonService salonService) throws SalonOwnerIdDoesNotExistException;

    // update the salon data
    public Salon updateSalon(Salon salon) throws SalonIdDoesNotExistException;

    // getting the salon data using salonId
    public Optional<Salon> getSalonBySalonId(String salonId);

    public List<Salon> getSalonByCity(String city);

    List<Salon> getSalonByName(String Name);

    boolean updateSlotBySlotId(String ownerId, String slotId,Slot updatedSlot) throws SalonOwnerIdDoesNotExistException;



}