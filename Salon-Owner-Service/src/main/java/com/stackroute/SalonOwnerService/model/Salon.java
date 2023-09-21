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
    List<SalonServiceTypes> SalonServiceTypesList;

    byte [] salonImage;

    public String getHotelId() {
        return salonId;
    }

    public void setHotelId(String hotelId) {
        this.salonId = salonId;
    }

    public String getHotelName() {
        return salonName;
    }

    public void setHotelName(String hotelName) {
        this.salonName = salonName;
    }

    public String getHotelAddress() {
        return salonAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.salonAddress = salonAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReferalCode() {
        return referalCode;
    }

    public void setReferalCode(String referalCode) {
        this.referalCode = referalCode;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getAcNonAc() {
        return acNonAc;
    }

    public void setAcNonAc(String acNonAc) {
        this.acNonAc = acNonAc;
    }

    public String getNearbyTransportation() {
        return NearbyTransportation;
    }

    public void setNearbyTransportation(String nearbyTransportation) {
        NearbyTransportation = nearbyTransportation;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<SalonServiceTypes> getRoomList() {
        return SalonServiceTypesList;
    }

    public void setRoomList(List<SalonServiceTypes> roomList) {this.SalonServiceTypesList = roomList; }

    public byte[] getHotelImage() {
        return salonImage;
    }

    public void setHotelImage(byte[] hotelImage) {
        this.salonImage = salonImage;
    }
}
