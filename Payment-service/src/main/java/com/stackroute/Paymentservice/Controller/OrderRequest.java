package com.stackroute.Paymentservice.Controller;

import lombok.Getter;

import java.math.BigInteger;

@Getter
public class OrderRequest {

    String customerName;
    String email;
    String phoneNumber;
    BigInteger amount;


    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }
}
