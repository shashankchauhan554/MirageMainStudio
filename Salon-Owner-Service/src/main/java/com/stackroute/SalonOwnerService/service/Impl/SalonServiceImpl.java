package com.stackroute.SalonOwnerService.service.Impl;

import com.stackroute.SalonOwnerService.exception.*;
import com.stackroute.SalonOwnerService.model.Salon;
import com.stackroute.SalonOwnerService.model.Slot;
import com.stackroute.SalonOwnerService.repository.SalonRepository;
import com.stackroute.SalonOwnerService.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalonServiceImpl implements SalonService {

    @Autowired
    SalonRepository repository;

    @Override

    public Salon addSalon(Salon salon) throws SalonIdAlreadyExistException {

        Optional<Salon> opt = repository.findById(salon.getSalonId());

        if (salon.getSalonName() == null ||
                salon.getEmail() == null || salon.getSalonOwnerName() == null || opt.isPresent()) {
            throw new SalonIdAlreadyExistException("Already Exist");
        } else {
            return repository.save(salon);
        }
    }
    @Override
    public Salon addService(String ownerId, com.stackroute.SalonOwnerService.model.SalonService salonService) throws SalonOwnerIdDoesNotExistException {
//        Optional<Salon> optionalSalonOwner = repository.findById(ownerId);
//
//        if (optionalSalonOwner.isEmpty()) {
//            throw new SalonOwnerIdDoesNotExistException("notFound");
//        } else {
//            Salon salonOwner = optionalSalonOwner.get();
//            List<com.stackroute.SalonOwnerService.model.SalonService> existSalon = salonOwner.getSalonServices();
//
//            if (existSalon == null) {
//                existSalon = new ArrayList<>(); // Create a new list if it's null
//            }
//
//            existSalon.add((com.stackroute.SalonOwnerService.model.SalonService) salon.getCategoryList());
//            salonOwner.setSalonServices(existSalon);
////            Optional<List<Salon>> optionalSalonList = Optional.ofNullable(salonOwner.getSalonList());
////            optionalSalonList.ifPresent(salons ->
////                    salons.forEach(salonlist -> salonRepository.save(salon)));
//
//            repository.save(salonOwner);
//            Optional<Salon> updatedservice = repository.findById(ownerId);
//            return updatedservice;
//        }

        Salon salon1;
        com.stackroute.SalonOwnerService.model.SalonService salonService1 = null;
        Optional<Salon> opt = repository.findById(ownerId);
        if (opt.isPresent()) {

            salon1 = opt.get();
            System.out.println(salon1);

            List<com.stackroute.SalonOwnerService.model.SalonService> servicelist = salon1.getSalonServices();
            System.out.println(servicelist);
            if (servicelist == null) {
                servicelist= new ArrayList<>(); // Create a new list if it's null
            }
            servicelist.add(salonService);

            salon1.setSalonServices(servicelist);

        } else {
            throw new SalonOwnerIdDoesNotExistException("notFound");
        }
        try {
            return repository.save(salon1);
        } catch (Exception e) {
            throw new SalonOwnerIdDoesNotExistException("Not Found");
        }
    }

    @Override
    public Salon addSlot(String ownerId, Slot slot) throws SalonOwnerIdDoesNotExistException {


        Salon salon1;
        com.stackroute.SalonOwnerService.model.SalonService salonService1 = null;
        Optional<Salon> opt = repository.findById(ownerId);
        if (opt.isPresent()) {

            salon1 = opt.get();
            System.out.println(salon1);

            List<Slot> slotlist = salon1.getSlots();
            System.out.println(slotlist);
            if (slotlist == null) {
                slotlist= new ArrayList<>(); // Create a new list if it's null
            }
            slotlist.add(slot);

            salon1.setSlots(slotlist);

        } else {
            throw new SalonOwnerIdDoesNotExistException("notFound");
        }
        try {
            return repository.save(salon1);
        } catch (Exception e) {
            throw new SalonOwnerIdDoesNotExistException("Not Found");
        }
    }


    @Override
    public Optional<Salon> viewSalonById(String ownerId)throws SalonOwnerIdDoesNotExistException
    {
        Optional<Salon> updatedservice = repository.findById(ownerId);
        return updatedservice;
    }

    @Override
    public boolean deleteSalonbySalonId(String salonId) throws SalonIdDoesNotExistException {

        Optional<Salon> optionalSalon = repository.findById(salonId);
        if(optionalSalon.isPresent()){
            repository.deleteById(salonId);
            return true;
        }else
            throw new SalonIdDoesNotExistException("Salon Id is not available in DB");
    }

    @Override
    public Salon updateSalon(Salon salon) throws SalonIdDoesNotExistException {
        Optional<Salon> optionalCategory = repository.findById(salon.getSalonId());
        if(optionalCategory.isPresent()){
            return repository.save(salon);
        }else
            throw new SalonIdDoesNotExistException("Salon Id is not Available in DB");
    }

    @Override
    public Optional<Salon> getSalonBySalonId(String salonId) {
        return repository.findById(salonId);
    }



    @Override
    public List<Salon> getSalonByLocation(String location) {
        return repository.findByCity(location);
    }
    @Override
    public Salon getSalonByName(String name) {return repository.findBySalonName(name);
    }




}