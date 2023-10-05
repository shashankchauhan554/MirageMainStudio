package com.stackroute.Paymentservice.Service;

import com.stackroute.Paymentservice.Controller.OrderRequest;
import com.stackroute.Paymentservice.Model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import com.stackroute.Paymentservice.repository.DBRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DBService {

    @Autowired
    private DBRepository dbRepository;

    public Payment savePayment(Payment payment)
    {
        String userEmail = "";
        payment.setEmail(userEmail);
        return dbRepository.save(payment);
    }

    public Payment getPayment(String email)
    {
        Optional<Payment> optional = dbRepository.findById(email);
        Payment payment = optional.get();
        return payment;
    }

    public Payment updatePayment(Payment payment, String email)
    {
        payment.setEmail(email);
        return dbRepository.save(payment);
    }

    public void deletePayment(String email)
    {
        dbRepository.deleteById(email);
    }

    public List<Payment> getAllPayment()
    {
        return dbRepository.findAll();
    }
}

