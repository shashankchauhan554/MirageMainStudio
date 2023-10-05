package com.stackroute.SalonOwnerService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Document(indexName = "slots")
public class Slot {

    @Id
    String slotId;

    Date slotDate;

    Status slotStatus;

    String slotTime;
}
