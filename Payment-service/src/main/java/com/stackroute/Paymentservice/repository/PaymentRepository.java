package com.stackroute.Paymentservice.repository;

import com.stackroute.Paymentservice.Model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
