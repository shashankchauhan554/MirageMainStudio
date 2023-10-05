package com.stackroute.Paymentservice.repository;

import com.stackroute.Paymentservice.Controller.OrderRequest;
import com.stackroute.Paymentservice.Model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DBRepository extends MongoRepository<Payment, String> {

}
