package com.stackroute.SalonOwnerService.controller;

import com.stackroute.SalonOwnerService.exception.*;
import com.stackroute.SalonOwnerService.model.Salon;
import com.stackroute.SalonOwnerService.model.Category;
import com.stackroute.SalonOwnerService.service.Impl.SalonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("salon")
@CrossOrigin("*")

public class SalonController {
    @Autowired
    SalonServiceImpl service;

    @PostMapping("/addsalon")
    public ResponseEntity<?> addSalon(@RequestBody Salon salon) throws SalonIdAlreadyExistException, IOException {
        Salon salon1 = service.addSalon(salon);
        return new ResponseEntity<>(salon1, HttpStatus.CREATED);
    }


    @GetMapping("/viewall")
    public ResponseEntity<?> viewAllSalon()  {
        Iterable<Salon> salonList = service.viewAllSalons();
        return new ResponseEntity<Iterable>(salonList, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{sId}")
    public ResponseEntity<?> deleteSalon(@PathVariable("sId") String sid){
        try {
            boolean result = service.deleteSalonbySalonId(sid);
            return new ResponseEntity<String>("Salon Deleted", HttpStatus.OK);
        } catch (SalonIdDoesNotExistException e) {
            return new ResponseEntity<String>("salonId not Found in DB", HttpStatus.NOT_FOUND);
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

    @PostMapping("/addcategory/{salonId}")
    public ResponseEntity<?> addCategory(@PathVariable String salonId, @RequestBody Category category) {
        Salon salon = null;
        try {
            salon = service.addCategory(salonId, category);
            return new ResponseEntity<Salon>(salon, HttpStatus.CREATED);
        } catch (SalonIdDoesNotExistException e) {
            return new ResponseEntity<String>("Invalid Salon No", HttpStatus.CONFLICT);
        }
    }


    @GetMapping("viewbyaddr/{location}")
    public ResponseEntity<List> viewByLocation(@PathVariable String location){
        return  new ResponseEntity<List>(service.getSalonByLocation(location),HttpStatus.OK);
    }
    @GetMapping("viewbyname/{name}")
    public ResponseEntity<Salon> viewByName(@PathVariable String name){
        return  new ResponseEntity<>(service.getSalonByName(name),HttpStatus.OK);
    }
    @GetMapping("viewbypricegreaterthan/{maxprice}")
    public ResponseEntity<?> viewByPrice(@PathVariable int maxprice){
        List<Salon> salonList = service.getSalonBasedOnCost(maxprice);
        return new ResponseEntity<List>(salonList,HttpStatus.OK);
    }
}