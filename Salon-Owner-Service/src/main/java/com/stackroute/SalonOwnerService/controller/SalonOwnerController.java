package com.stackroute.SalonOwnerService.controller;

import com.stackroute.SalonOwnerService.exception.*;
import com.stackroute.SalonOwnerService.model.Salon;
import com.stackroute.SalonOwnerService.model.SalonOwner;
import com.stackroute.SalonOwnerService.service.Impl.SalonOwnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class SalonOwnerController {
    @Autowired
    SalonOwnerServiceImpl service;

    // adding the new Salon Owner
    @PostMapping("/addsalonowner")
    public ResponseEntity<?> addSalonOwner(@RequestBody SalonOwner salonOwner) throws SalonOwnerIdAlreadyExistException, IOException {
        SalonOwner salonOwner1 = service.addSalonOwner(salonOwner);
        return new ResponseEntity<>(salonOwner1, HttpStatus.CREATED);
    }

    // fetch the all owner
    @GetMapping("/viewallsalonowner")
    public ResponseEntity<?> viewAllSalonOwner() {
        Iterable<SalonOwner> salonOwnerList = service.viewAllSalonOwner();
        return new ResponseEntity<Iterable>(salonOwnerList, HttpStatus.OK);
    }

    // delete the owner using owner id
    @DeleteMapping("/deletesalonowner/{oId}")
    public ResponseEntity<?> deleteSalonOwner(@PathVariable("oId") String oid) {
        try {
            boolean result = service.deleteSalonOwnerbyOwnerId(oid);
            return new ResponseEntity<String>("SalonOwner Deleted", HttpStatus.OK);
        } catch (SalonOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>("Id not Found in DB", HttpStatus.NOT_FOUND);
        }
    }

    // update the owner details
    @PutMapping("/updatesalonowner")
    public ResponseEntity<?> updateOwnerDetails(@RequestBody SalonOwner salonOwner) {
        try {
            SalonOwner salonOwner1 = service.updateOwner(salonOwner);
            return new ResponseEntity<SalonOwner>(salonOwner1, HttpStatus.OK);
        } catch (SalonOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // getting all the data using owner Id
    @GetMapping("/viewbyownerId/{ownerId}")
    public Optional<SalonOwner> viewByOwnerId(@PathVariable("ownerId") String ownerId ){
        return service.getOwnerByOwnerId(ownerId);
    }

    //putting the salon data using ownerId  @RequestBody Salon salon

    @PostMapping("/addsalon/{ownerId}")
    public ResponseEntity<?> addSalon(@PathVariable String ownerId, @RequestBody Salon salon) {
        SalonOwner salonOwner = null;
        try {
            salonOwner = service.addSalon(ownerId, salon);
            return new ResponseEntity<SalonOwner>(salonOwner, HttpStatus.CREATED);
        } catch (SalonOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/delete/salon/{ownerId}/{salonId}")
    public ResponseEntity<?> deletesalon(@PathVariable String ownerId, @PathVariable String salonId) {
        try {
            boolean result = service.deleteSalon(ownerId, salonId);
            return new ResponseEntity<String>("Salon is Deleted", HttpStatus.OK);
        } catch (SalonOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>("Invalid Owner id", HttpStatus.NOT_FOUND);
        } catch (SalonIdDoesNotExistException e) {
            return new ResponseEntity<String>("Salon id not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/viewbyname/salon/{ownerId}/{salonName}")
    public ResponseEntity<?> getSalonByName(@PathVariable("ownerId") String ownerId, @PathVariable String salonName) {
        try {
            Salon salon = service.getSalonByName(ownerId, salonName);
            return new ResponseEntity<Salon>(salon, HttpStatus.OK);
        } catch (SalonOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>("Invalid Owner id", HttpStatus.NOT_FOUND);
        } catch (SalonNameNotFoundException e) {
            return new ResponseEntity<String>("Salon id not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/viewbylocation/salon/{ownerId}/{salonAddress}")
    public ResponseEntity<?> getSalonByAddress(@PathVariable("ownerId") String ownerId, @PathVariable("salonAddress") String salonAddress) {
        try {
            Salon salon = service.getSalonByAddress(ownerId, salonAddress);
            return new ResponseEntity<Salon>(salon, HttpStatus.OK);
        } catch (SalonOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>("Invalid Owner id", HttpStatus.NOT_FOUND);
        } catch (SalonNameNotFoundException e) {
            return new ResponseEntity<String>("Salon not found", HttpStatus.NOT_FOUND);
        }
    }
}