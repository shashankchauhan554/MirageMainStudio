package com.stackroute.SalonOwnerService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "salon")
public class Salon {

    @Id
    private String id;
    private String name;
    private String address;
    private String email;
    private String description;
    private String number;
    private LocalDateTime time;

}
