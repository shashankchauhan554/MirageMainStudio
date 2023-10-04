package com.stackroute.Paymentservice.repositry;

import com.stackroute.Paymentservice.Controller.OrderRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DBRepository extends MongoRepository<OrderRequest, String> {

}
