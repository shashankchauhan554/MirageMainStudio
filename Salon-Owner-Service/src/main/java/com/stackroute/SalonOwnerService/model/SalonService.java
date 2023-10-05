package com.stackroute.SalonOwnerService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "salonservice")
public class SalonService {

    @Id
    String serviceId;

    String serviceName;

    double price;

}
