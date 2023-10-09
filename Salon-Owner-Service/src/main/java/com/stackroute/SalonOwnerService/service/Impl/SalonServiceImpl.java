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
            System.out.println(salon.getImage());
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
    public Iterable<Salon> viewAllSalon()
    {
        Iterable<Salon> allsalons = repository.findAll();
        return allsalons;
    }

    @Override
    public Optional<Salon> viewSalonById(String ownerId)throws SalonOwnerIdDoesNotExistException
    {
        Optional<Salon> salon = repository.findById(ownerId);
        return salon;
    }

    @Override
    public Optional<Salon> viewSalonByEmailId(String emailId)throws SalonOwnerIdDoesNotExistException
    {
        Optional<Salon> salon = repository.findByEmail(emailId);
        return salon;
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
    public List<Salon> getSalonByCity(String city) {
        return repository.findByCity(city);
    }



    @Override
    public List<Salon> getSalonByName(String Name) {
        return repository.findBySalonName(Name);
    }

    @Override
    public boolean deleteSlotBySlotId(String ownerId, String slotId) throws SalonOwnerIdDoesNotExistException {
        Optional<Salon> opt = repository.findById(ownerId);
        if (opt.isPresent()) {
            Salon salon = opt.get();
            List<Slot> slots = salon.getSlots();
            if (slots != null) {
                // Find the slot with the specified slotId and remove it
                slots.removeIf(slot -> slot.getSlotId().equals(slotId));
                salon.setSlots(slots);
                repository.save(salon);
                return true;
            }
        }
        throw new SalonOwnerIdDoesNotExistException("Salon or Slot not found");
    }
    @Override
    public boolean deleteSalonService(String ownerId, String serviceId) throws SalonOwnerIdDoesNotExistException {
        Optional<Salon> opt = repository.findById(ownerId);
        if (opt.isPresent()) {
            Salon salon = opt.get();
            List<com.stackroute.SalonOwnerService.model.SalonService> services = salon.getSalonServices();
            if (services != null) {
                // Find the service with the specified serviceId and remove it
                services.removeIf(service -> service.getServiceId().equals(serviceId));
                salon.setSalonServices(services);
                repository.save(salon);
                return true;
            }
        }
        throw new SalonOwnerIdDoesNotExistException("Salon or SalonService not found");
    }
    @Override
    public boolean editSlotBySlotId(String ownerId, String slotId, Slot updatedSlot) throws SalonOwnerIdDoesNotExistException {
        Optional<Salon> opt = repository.findById(ownerId);
        if (opt.isPresent()) {
            Salon salon = opt.get();
            List<Slot> slots = salon.getSlots();
            if (slots != null) {
                slots.removeIf(slot -> slot.getSlotId().equals(slotId));
                slots.add(updatedSlot);
                salon.setSlots(slots);
                repository.save(salon);
                return true;
            }
        }
        return false; // Slot or owner not found
    }
    @Override
    public Salon editService(String ownerId, String serviceId, com.stackroute.SalonOwnerService.model.SalonService salonService) throws SalonOwnerIdDoesNotExistException {
        Optional<Salon> opt = repository.findById(ownerId);
        if (opt.isPresent()) {
            Salon salon = opt.get();
            List<com.stackroute.SalonOwnerService.model.SalonService> services = salon.getSalonServices();
            if (services != null) {
                // Find the service with the specified serviceId
//                for (SalonService service : services) {
//                    if (service.getServiceId().equals(serviceId)) {
//                        // Update the service with the new data
//                        service.setServiceName(salonService.getServiceName());
//                        service.setServiceDescription(salonService.getServiceDescription());
//                        service.setServicePrice(salonService.getServicePrice());
//                        // Save the updated salon
//                        repository.save(salon);
//                        return salon;
//                    }
//                }
                services.removeIf(service -> service.getServiceId().equals(serviceId));
                services.add(salonService);
                salon.setSalonServices(services);
                repository.save(salon);
                return salon;
            }
        }
        throw new SalonOwnerIdDoesNotExistException("Salon or Service not found");
    }

    @Override
    public boolean updateSlotBySlotId(String ownerId, String slotId,Slot updatedSlot) throws SalonOwnerIdDoesNotExistException {
        Optional<Salon> opt = repository.findById(ownerId);
        if (opt.isPresent()) {
            Salon salon = opt.get();
            List<Slot> slots = salon.getSlots();
            if (slots != null) {
                slots.removeIf(slot -> slot.getSlotId().equals(slotId));
                slots.add(updatedSlot);
                salon.setSlots(slots);
                repository.save(salon);
                return true;
            }
        }
        return false; // Slot or owner not found
    }




}