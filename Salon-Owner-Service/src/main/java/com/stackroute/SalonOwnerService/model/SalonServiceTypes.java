package com.stackroute.SalonOwnerService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "serviceTypes")
public class SalonServiceTypes {
    @Id
    String serviceId;
    String serviceType;
    int price;
    String acNonAc;
    String wifi;
    String maintanance;
    byte[] serviceTypeImage;

    public String getRoomId() {
        return serviceId;
    }

    public void setRoomId(String roomId) {
        this.serviceId = serviceId;
    }

    public String getBedType() {
        return serviceType;
    }

    public void setBedType(String bedType) {
        this.serviceType = serviceType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAcNonAc() {
        return acNonAc;
    }

    public void setAcNonAc(String acNonAc) {
        this.acNonAc = acNonAc;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getMaintanance() {
        return maintanance;
    }

    public void setMaintanance(String maintanance) {
        this.maintanance = maintanance;
    }

    public byte[] getRoomImage() {return serviceTypeImage; }

    public void setRoomImage(byte[] roomImage) {
        this.serviceTypeImage = serviceTypeImage;
    }

}
