package com.stackroute.SalonOwnerService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import java.time.LocalDateTime;

@Data
@Document(indexName = "salonbookings")
public class Salon {

    @Id
    private String id;
    private String customerName;
    private String serviceName;
    // Other fields relevant to the booking
    // Constructors, getters, setters, toString, etc.
}
