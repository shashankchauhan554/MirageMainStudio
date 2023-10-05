package com.stackroute.SalonOwnerService.controller;

import com.stackroute.SalonOwnerService.exception.*;
import com.stackroute.SalonOwnerService.model.*;
import com.stackroute.SalonOwnerService.service.Impl.SalonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("salon")
@CrossOrigin(origins = "http://localhost:4200/")

public class SalonController {
    @Autowired
    SalonServiceImpl service;

    @PostMapping("/addsalon")
    public ResponseEntity<?> addSalon(@RequestBody Salon salon) throws SalonIdAlreadyExistException, IOException {
        Salon salon1 = service.addSalon(salon);
        return new ResponseEntity<>(salon1, HttpStatus.CREATED);
    }

    @PostMapping("/addservice/{ownerId}")
    public ResponseEntity<?> addSalonService(@PathVariable String ownerId, @RequestBody SalonService salonService) {
        Salon salonOwner = null;
        try {
            service.addService(ownerId, salonService);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (SalonOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/addslot/{ownerId}")
    public ResponseEntity<?> addSlot(@PathVariable String ownerId, @RequestBody Slot slot) {
        Salon salonOwner = null;
        try {
            service.addSlot(ownerId, slot);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (SalonOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @DeleteMapping("/delete/{ownerId}/{slotId}")
    public ResponseEntity<?> deleteSlot(@PathVariable String ownerId, @PathVariable String slotId) {
        try {
            service.deleteSlotBySlotId(ownerId, slotId);
            return new ResponseEntity<String>("Slot Deleted", HttpStatus.OK);
        } catch (SalonOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @DeleteMapping("/deleteservice/{ownerId}/{serviceId}")
    public ResponseEntity<?> deleteSalonService(@PathVariable String ownerId, @PathVariable String serviceId) {
        try {
            boolean result = service.deleteSalonService(ownerId, serviceId);
            if (result) {
                return new ResponseEntity<String>("SalonService Deleted", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("SalonService not found for the given ownerId and serviceId", HttpStatus.NOT_FOUND);
            }
        } catch (SalonOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/viewall/{ownerId}")
    public ResponseEntity<?> viewAllSalon(@PathVariable String ownerId)  {
        Optional<Salon> salonOwner = null;
        try {
            salonOwner = service.viewSalonById(ownerId);
            return new ResponseEntity<Optional<Salon>>(salonOwner, HttpStatus.CREATED);
        } catch (SalonOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

//    @DeleteMapping("/delete/{sId}")
//    public ResponseEntity<?> deleteSalon(@PathVariable("sId") String sid){
//        try {
//            boolean result = service.deleteSalonbySalonId(sid);
//            return new ResponseEntity<String>("Salon Deleted", HttpStatus.OK);
//        } catch (SalonIdDoesNotExistException e) {
//            return new ResponseEntity<String>("salonId not Found in DB", HttpStatus.NOT_FOUND);
//        }
//    }
    @PostMapping("/editslot/{ownerId}/{slotId}")
    public ResponseEntity<?> editSlot(@PathVariable String ownerId, @PathVariable String slotId, @RequestBody Slot updatedSlot) {
//        System.out.println("Hello, World!");
        try {
            boolean result  = service.editSlotBySlotId(ownerId, slotId, updatedSlot);
            if (result) {
                return new ResponseEntity<String>("Slot Updated", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Slot not found for the given ownerId and slotId", HttpStatus.NOT_FOUND);
            }
        } catch (SalonOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @PostMapping("/editservice/{ownerId}/{serviceId}")
    public ResponseEntity<?> editService(
            @PathVariable String ownerId,
            @PathVariable String serviceId,
            @RequestBody SalonService salonService) {
        try {
            Salon salon = service.editService(ownerId, serviceId, salonService);
            if (salon != null) {
                return new ResponseEntity<>(salon, HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Service not found for the given ownerId and serviceId", HttpStatus.NOT_FOUND);
            }
        } catch (SalonOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    // update the salon details
    @PutMapping("/update")
    public ResponseEntity<?> updateSalon(@RequestBody Salon salon) throws IOException {
        try {
            Salon salon1 = service.updateSalon(salon);
            return new ResponseEntity<>(salon1, HttpStatus.OK);
        } catch (SalonIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("viewbyId/{salonId}")
    public Optional<Salon> viewBySalonId(@PathVariable("salonId") String salonId){
        return service.getSalonBySalonId(salonId);
    }

    @GetMapping("viewbyaddr/{location}")
    public ResponseEntity<List> viewByLocation(@PathVariable String location){
        return  new ResponseEntity<List>(service.getSalonByLocation(location),HttpStatus.OK);
    }
//

}