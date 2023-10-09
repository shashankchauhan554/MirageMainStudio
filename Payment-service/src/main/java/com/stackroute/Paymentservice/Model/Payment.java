package com.stackroute.Paymentservice.Model;

import lombok.Getter;

import java.math.BigInteger;
@Getter
public class Payment {
    String customerName;
    String customerEmail;
    String phoneNumber;
    BigInteger amount;
    String razorpayPaymentId;
    String razorpayOrderId;
    String signature;

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.customerEmail = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public void setRazorpayPaymentId(String razorpayPaymentId) {
        this.razorpayPaymentId = razorpayPaymentId;
    }

    public void setRazorpayOrderId(String razorpayOrderId) {
        this.razorpayOrderId = razorpayOrderId;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
