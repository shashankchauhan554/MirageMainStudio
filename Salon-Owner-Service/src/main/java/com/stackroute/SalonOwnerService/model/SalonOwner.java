package com.stackroute.SalonOwnerService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;
@Data
@Document(indexName= "SalonOwner")
public class SalonOwner {
    // Salon Owner Properties
    @Id
    String ownerId;
    String email;
    String name;
    String mobileNo;
    String referalCode;
    String addr;
    String dob;
    List<Salon>salonList;
    boolean aprovedbyadmin ;

    public boolean isAprovedbyadmin() {
        return aprovedbyadmin;
    }

    public void setAprovedbyadmin(boolean aprovedbyadmin) {
        this.aprovedbyadmin = aprovedbyadmin;
    }

    public List<Salon> getSalonList() {
        return salonList;
    }

    public void setSalonList(List<Salon> salonList) {
        this.salonList = salonList;
    }
}