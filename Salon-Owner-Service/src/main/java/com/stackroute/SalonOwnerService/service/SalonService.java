package com.stackroute.SalonOwnerService.service;

import com.stackroute.SalonOwnerService.model.Salon;
import com.stackroute.SalonOwnerService.repository.SalonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
@Service
public class SalonService {

    @Autowired
    private SalonRepo salonRepository;

    public void save(Salon salon) {
        salonRepository.save(salon);
    }

    public Optional<Salon> getById(String id) {
        return salonRepository.findById(id);
    }

    public List<Salon> getAll() {
        return (List<Salon>) salonRepository.findAll();
    }

    public void delete(String id) {
        salonRepository.deleteById(id);
    }
}
