package com.stackroute.SalonOwnerService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Data
@Document(indexName = "salon")
public class Salon {

    @Id
    String salonId;
    String salonName;
    String salonOwnerName;
    String city;
    String contactNumber;
    String gstNumber;
    String email;
    List<Slot> slots;
    List<SalonService> salonServices;
}
