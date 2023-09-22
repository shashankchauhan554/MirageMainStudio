package com.stackroute.SalonOwnerService.controller;

import com.stackroute.SalonOwnerService.exception.SalonIdAlreadyExistException;
import com.stackroute.SalonOwnerService.exception.SalonIdDoesNotExistException;
import com.stackroute.SalonOwnerService.model.Salon;
import com.stackroute.SalonOwnerService.model.Category;
import com.stackroute.SalonOwnerService.service.Impl.SalonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("salon")
@CrossOrigin("*")
public class SalonController {
    @Autowired
    SalonServiceImpl service;

    @PostMapping("/addsalon")

    public ResponseEntity<?> addSalon(@RequestParam(required = false,value = "salonId") String salonId,
                                      @RequestParam(required = false,value = "salonName")String salonName,
                                      @RequestParam(required = false,value = "salonAddress")String salonAddress,
                                      @RequestParam(required = false,value = "location")String location,
                                      @RequestParam(required = false,value = "referalCode")String referalCode,
                                      @RequestParam(required = false,value = "gstNumber")String gstNumber,
                                      @RequestParam(required = false,value = "availability")String availability,
                                      @RequestParam(required = false,value = "acNonAc")String acNonAc,
                                      @RequestParam(required = false,value = "nearbyTransportation")String nearbyTransportation,
                                      @RequestParam(required = false,value = "wifi")String wifi,
                                      @RequestParam(required = false,value = "maintanance")String maintanance,
                                      @RequestParam(required = false,value = "price")int price,
                                      @RequestParam(required = false,value = "roomList") List<Category> categoryList) throws SalonIdAlreadyExistException, IOException {
        Salon salon = new Salon();
        salon.setSalonId(salonId);
        salon.setSalonName(salonName);
        salon.setSalonAddress(salonAddress);
        salon.setLocation(location);
        salon.setReferalCode(referalCode);
        salon.setGstNumber(gstNumber);
        salon.setAvailability(availability);
        salon.setAcNonAc(acNonAc);
        salon.setNearbyTransportation(nearbyTransportation);
        salon.setWifi(wifi);
        salon.setMaintanance(maintanance);
        salon.setPrice(price);
        salon.setCategoryList(categoryList);
        Salon salon1 = service.addSalon(salon);    ///copy
        return new ResponseEntity<Salon>(salon1, HttpStatus.CREATED);

    }
    @GetMapping("viewall")
    public ResponseEntity<?> viewAllCategorys(){
        List<Salon> categoryList = (List<Salon>) service.viewAllSalons();
        return  new ResponseEntity<List>(categoryList,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{sId}")
    public ResponseEntity<?> deleteSalon(@PathVariable("sId") String sid){
        try {
            boolean result = service.deleteSalonbySalonId(sid);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SalonIdDoesNotExistException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateSalon(@RequestParam(required = false,value = "salonId") String salonId,
                                         @RequestParam(required = false,value = "salonName")String salonName,
                                         @RequestParam(required = false,value = "salonAddress")String salonAddress,
                                         @RequestParam(required = false,value = "location")String location,
                                         @RequestParam(required = false,value = "referalCode")String referalCode,
                                         @RequestParam(required = false,value = "gstNumber")String gstNumber,
                                         @RequestParam(required = false,value = "availability")String availability,
                                         @RequestParam(required = false,value = "acNonAc")String acNonAc,
                                         @RequestParam(required = false,value = "nearbyTransportation")String nearbyTransportation,
                                         @RequestParam(required = false,value = "wifi")String wifi,
                                         @RequestParam(required = false,value = "maintanance")String maintanance,
                                         @RequestParam(required = false,value = "price")int price,
                                         @RequestParam(required = false,value = "roomList") List<Category> categoryList)throws IOException {
        try{
            Salon salon = new Salon();
            salon.setSalonId(salonId);
            salon.setSalonName(salonName);
            salon.setSalonAddress(salonAddress);
            salon.setLocation(location);
            salon.setReferalCode(referalCode);
            salon.setGstNumber(gstNumber);
            salon.setAvailability(availability);
            salon.setAcNonAc(acNonAc);
            salon.setNearbyTransportation(nearbyTransportation);
            salon.setWifi(wifi);
            salon.setMaintanance(maintanance);
            salon.setPrice(price);
            salon.setCategoryList(categoryList);
            Salon salon1 = service.updateSalon(salon);
            return new ResponseEntity<Salon>(salon1,HttpStatus.OK);
        } catch (SalonIdDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("viewbyId/{salonId}")
    public Optional<Salon> viewBySalonId(@PathVariable String salonId){
        return service.getSalonBySalonId(salonId);
    }

    @PostMapping("/addcategory/{salonId}")
    public ResponseEntity<?> addSalonModel(@PathVariable String salonId,
                                           @RequestParam("roomId")String categoryId,
                                           @RequestParam(required = false,value = "bedType")String categoryType,
                                           @RequestParam(required = false,value = "price")int price,
                                           @RequestParam(required = false,value = "acNonAc")String acNonAc,
                                           @RequestParam(required = false,value = "wifi")String wifi,
                                           @RequestParam(required = false,value = "maintanance")String maintanance) throws IOException {

        Salon salon = null;
        try{
            Category category= new Category();
            category.setCategoryId(categoryId);
            category.setCategoryType(categoryType);
            category.setPrice(price);
            category.setAcNonAc(acNonAc);
            category.setWifi(wifi);
            category.setMaintanance(maintanance);
            salon = service.addCategory(salonId, category);
            return new ResponseEntity<Salon>(salon,HttpStatus.CREATED);
        } catch (SalonIdDoesNotExistException e) {
            return new ResponseEntity<String>("Invalid Hotel No",HttpStatus.CONFLICT);
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