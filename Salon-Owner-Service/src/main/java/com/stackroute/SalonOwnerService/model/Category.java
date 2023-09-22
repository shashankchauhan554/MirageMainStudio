package com.stackroute.SalonOwnerService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "categoryTypes")
public class Category {
    @Id
    String categoryId;
    String categoryType;
    int price;
    String acNonAc;
    String wifi;
    String maintanance;

}
