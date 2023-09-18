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
@RequestMapping("/salon")
public class SalonController {

    @Autowired
    private SalonService salonService;

    @PostMapping
    public void createSalon(@RequestBody Salon salon) {

        salonService.save(salon);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salon> getSalonById(@PathVariable String id) {
        Optional<Salon> salon = salonService.getById(id);
        return salon.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Salon> getAllSalons() {
        return salonService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteSalon(@PathVariable String id) {

        salonService.delete(id);
    }
}