package com.stackroute.SalonOwnerService.service.Impl;

import com.stackroute.SalonOwnerService.exception.*;
import com.stackroute.SalonOwnerService.model.Salon;
import com.stackroute.SalonOwnerService.model.SalonOwner;
import com.stackroute.SalonOwnerService.repository.SalonOwnerRepository;
import com.stackroute.SalonOwnerService.repository.SalonRepository;
import com.stackroute.SalonOwnerService.service.SalonOwnerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SalonOwnerServiceImpl implements SalonOwnerService {

    @Autowired
    SalonOwnerRepository repository;
    @Autowired
    SalonRepository salonRepository;

    @Override
    public SalonOwner addSalonOwner(SalonOwner salonOwner) throws SalonOwnerIdAlreadyExistException {
        SalonOwner salonOwner1;
        Optional<SalonOwner> optionalSalon = repository.findById(salonOwner.getOwnerId());
        if (optionalSalon.isPresent()) {
            throw new SalonOwnerIdAlreadyExistException("Duplicate Owner Id");
        }
        else {
            Optional<List<Salon>> optionalSalonList = Optional.ofNullable(salonOwner.getSalonList());
            optionalSalonList.ifPresent(salons ->
                    salons.forEach(salon -> salonRepository.save(salon)));
            salonOwner1 = repository.save(salonOwner);
        }
        return salonOwner1;

    }

    @Override
    public Iterable<SalonOwner> viewAllSalonOwner() {
        return repository.findAll();
    }

    @Override
    public boolean deleteSalonOwnerbyOwnerId(String ownerId) throws SalonOwnerIdDoesNotExistException {

        Optional<SalonOwner> optionalOwner = repository.findById(ownerId);
        if (optionalOwner.isPresent()) {
            repository.deleteById(ownerId);
            return true;
        }
        else
            throw new SalonOwnerIdDoesNotExistException("Owner Id is not available in DB");
    }

    @Override
    public SalonOwner updateOwner(SalonOwner salonOwner) throws SalonOwnerIdDoesNotExistException {
        Optional<SalonOwner> optionalOwner = repository.findById(salonOwner.getOwnerId());
        if (optionalOwner.isPresent()) {
            return repository.save(salonOwner);
        }
        else
            throw new SalonOwnerIdDoesNotExistException("Owner Id is not Available in DB");
    }

    @Override
    public Optional<SalonOwner> getOwnerByOwnerId(String ownerId) {
        return repository.findById(ownerId);
    }

    @Override
    public SalonOwner addSalon(String ownerId, Salon salon) throws SalonOwnerIdDoesNotExistException {
        Optional<SalonOwner> optionalSalonOwner = repository.findById(ownerId);

        if (optionalSalonOwner.isEmpty()) {
            throw new SalonOwnerIdDoesNotExistException("notFound");
        } else {
            SalonOwner salonOwner = optionalSalonOwner.get();
            List<Salon> existSalon = salonOwner.getSalonList();

            if (existSalon == null) {
                existSalon = new ArrayList<>(); // Create a new list if it's null
            }

            existSalon.add(salon);
            salonOwner.setSalonList(existSalon);
            Optional<List<Salon>> optionalSalonList = Optional.ofNullable(salonOwner.getSalonList());
            optionalSalonList.ifPresent(salons ->
                    salons.forEach(salonlist -> salonRepository.save(salon)));
            return repository.save(salonOwner);
        }
    }

    @Override
    public boolean deleteSalon(String ownerId, String salonId) throws SalonOwnerIdDoesNotExistException, SalonIdDoesNotExistException {
        Optional<SalonOwner> salonOwner = repository.findById(ownerId);
        if (salonOwner.isEmpty()) {
            throw new SalonOwnerIdDoesNotExistException("Not Found");
        } else {
            SalonOwner salonOwner1 = salonOwner.get();
            List<Salon> existSalon = salonOwner1.getSalonList();
            existSalon.removeIf((med) -> med.getSalonId().equals(salonId));
            salonOwner1.setSalonList(existSalon);
            repository.save(salonOwner1);
            return true;
        }
    }

    @Override
    public Salon getSalonByName(String ownerId, String salonName) throws SalonOwnerIdDoesNotExistException, SalonNameNotFoundException {

        Optional<SalonOwner> salonOwner = repository.findById(ownerId);
        if (ownerId.isEmpty()) {
            throw new SalonOwnerIdDoesNotExistException("Not Found");
        } else {
            SalonOwner existSalonOwner = salonOwner.get();
            List<Salon> existSalonList = existSalonOwner.getSalonList();
            Optional<Salon> salonresult = existSalonList.stream().
                    filter(salon -> salon.getSalonName().equals(salonName)).findFirst();

            if (salonresult.isEmpty()) {
                throw new SalonNameNotFoundException("Not Found");
            } else {
                return salonresult.get();
            }
        }

    }

    @Override
    public Salon getSalonByAddress(String ownerId, String salonAddress) throws SalonOwnerIdDoesNotExistException, SalonNameNotFoundException {

        Optional<SalonOwner> salonOwner = repository.findById(ownerId);
        if (ownerId.isEmpty()) {
            throw new SalonOwnerIdDoesNotExistException("Not Found");
        }
        else {
            SalonOwner existSalonOwner = salonOwner.get();
            List<Salon> existSalonList = existSalonOwner.getSalonList();
            Optional<Salon> salonresult = existSalonList.stream().
                    filter(salon -> salon.getSalonAddress().equals(salonAddress)).findFirst();

            if (salonresult.isEmpty()) {
                throw new SalonNameNotFoundException("Not Found");
            }
            else {
                return salonresult.get();
            }
        }

    }
}