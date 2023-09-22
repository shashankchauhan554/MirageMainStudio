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
    String salonAddress;
    String location;
    String referalCode;
    String gstNumber;
    String availability;
    String acNonAc;
    String NearbyTransportation;
    String wifi;
    String maintanance;
    int price;
    List<Category> categoryList;
//    byte [] salonImage;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

}
