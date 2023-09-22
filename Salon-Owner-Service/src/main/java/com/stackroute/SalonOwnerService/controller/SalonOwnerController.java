package com.stackroute.SalonOwnerService.controller;

import com.stackroute.SalonOwnerService.exception.*;
import com.stackroute.SalonOwnerService.model.Salon;
import com.stackroute.SalonOwnerService.model.SalonOwner;
import com.stackroute.SalonOwnerService.model.Category;
import com.stackroute.SalonOwnerService.service.Impl.SalonOwnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class SalonOwnerController {
    @Autowired
    SalonOwnerServiceImpl service;

    // adding the new Salon Owner
    @PostMapping("/addsalonowner")
    public ResponseEntity<?> addSalonOwner(@RequestParam("ownerId") String ownerId,
                                           @RequestParam(required = false, value = "email") String email,
                                           @RequestParam(required = false, value = "name") String name,
                                           @RequestParam(required = false, value = "mobileNo") String mobileNo,
                                           @RequestParam(required = false, value = "referalCode") String referalCode,
                                           @RequestParam(required = false, value = "addr") String addr,
                                           @RequestParam(required = false, value = "dob") String dob,
                                           @RequestParam(required = false, value = "salonList") List<Salon> salonList) throws SalonOwnerIdAlreadyExistException, IOException {

        SalonOwner salonOwner = new SalonOwner();
        salonOwner.setOwnerId(ownerId);
        salonOwner.setName(name);
        salonOwner.setEmail(email);
        salonOwner.setAddr(addr);
        salonOwner.setMobileNo(mobileNo);
        salonOwner.setReferalCode(referalCode);
        salonOwner.setDob(dob);
        salonOwner.setSalonList(salonList);
        SalonOwner salonOwner1 = service.addSalonOwner(salonOwner);
        return new ResponseEntity<SalonOwner>(salonOwner1, HttpStatus.CREATED);
    }
    // fetch the all owner
    @GetMapping("viewallsalonowner")
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
    @GetMapping("viewbyownerId/{ownerId}")
    public Optional<SalonOwner> viewByOwnerId(@PathVariable String ownerId) {
        return service.getOwnerByOwnerId(ownerId);
    }
    //putting the salon data using ownerId  @RequestBody Salon salon
    @PostMapping("/addsalon/{ownerId}")
    public ResponseEntity<?> addSalon(@PathVariable String ownerId, @RequestParam("salonId") String salonId,
                                      @RequestParam(required = false, value = "salonName") String salonName,
                                      @RequestParam(required = false, value = "salonAddress") String salonAddress,
                                      @RequestParam(required = false, value = "location") String location,
                                      @RequestParam(required = false, value = "referalCode") String referalCode,
                                      @RequestParam(required = false, value = "gstNumber") String gstNumber,
                                      @RequestParam(required = false, value = "availability") String availability,
                                      @RequestParam(required = false, value = "acNonAc") String acNonAc,
                                      @RequestParam(required = false, value = "nearbyTransportation") String nearbyTransportation,
                                      @RequestParam(required = false, value = "wifi") String wifi,
                                      @RequestParam(required = false, value = "maintanance") String maintanance,
                                      @RequestParam(required = false, value = "price") int price,
                                      @RequestParam(required = false, value = "roomList") List<Category> categoryList) throws IOException {
        SalonOwner salonOwner = null;
        try {
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
            salonOwner = service.addSalon(ownerId, salon);
            return new ResponseEntity<SalonOwner>(salonOwner, HttpStatus.CREATED);
        } catch (SalonOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
//    @GetMapping("viewbyaddr/{addr}")
//    public ResponseEntity<List> viewByAddress(@PathVariable String addr){
//        return  new ResponseEntity<List>(service.getSalonOwnerByAddr(addr),HttpStatus.OK);
//    }
    @DeleteMapping("/delete/salon/{ownerId}/{salonId}")
    public ResponseEntity<?> deletesalon(@PathVariable String ownerId, @PathVariable String salonId){
        try {
            boolean result = service.deleteSalon(ownerId,salonId);
            return  new ResponseEntity<String>("Salon is Deleted",HttpStatus.OK);
        } catch (SalonOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>("Invalid Owner id",HttpStatus.NOT_FOUND);
        } catch (SalonIdDoesNotExistException e) {
            return new ResponseEntity<String>("Salon id not found",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/viewbyname/salon/{ownerId}/{salonName}")
    public ResponseEntity<?> getSalonByName(@PathVariable("ownerId") String ownerId, @PathVariable String salonName){
        try {
            Salon salon = service.getSalonByName(ownerId,salonName);
            return new ResponseEntity<Salon>(salon,HttpStatus.OK);
        } catch (SalonOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>("Invalid Owner id",HttpStatus.NOT_FOUND);
        } catch (SalonNameNotFoundException e) {
            return new ResponseEntity<String>("Salon id not found",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/viewbylocation/salon/{ownerId}/{salonAddress}")
    public ResponseEntity<?> getSalonByAddress(@PathVariable("ownerId") String ownerId, @PathVariable String salonAddress){
        try {
            Salon salon = service.getSalonByAddress(ownerId,salonAddress);
            return new ResponseEntity<Salon>(salon,HttpStatus.OK);
        } catch (SalonOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>("Invalid Owner id",HttpStatus.NOT_FOUND);
        } catch (SalonNameNotFoundException e) {
            return new ResponseEntity<String>("Salon not found",HttpStatus.NOT_FOUND);
        }
    }
//    @GetMapping("getData")
//    public ResponseEntity<?> getFakeData(){
//        RestTemplate template = new RestTemplate();
//        String url = "https://jsonplaceholder.typicode.com/users";
//        ResponseEntity<String> response = null;
//        response = template.exchange(url, HttpMethod.GET,getEntity(),String.class);
//        return  new ResponseEntity<String>(response.getBody(),HttpStatus.OK);
//    }
//    private HttpEntity getEntity(){
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//        return new HttpEntity(headers);
//    }
//    @PostMapping("/upload")
//    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws IOException {
//        return new ResponseEntity<String>(service.addFile(file), HttpStatus.OK);
//    }
//
//    @GetMapping("/view/{id}")
//    public ResponseEntity<ByteArrayResource> view(@PathVariable String id) throws IOException {
//        Image image = service.downloadFile(id);
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(image.getFileType() ))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getFilename() + "\"")
//                .body(new ByteArrayResource(image.getFile()));
//    }
}
