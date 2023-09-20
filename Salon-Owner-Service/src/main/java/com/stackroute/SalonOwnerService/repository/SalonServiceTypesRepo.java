package com.stackroute.SalonOwnerService.repository;

import com.stackroute.SalonOwnerService.model.SalonServiceTypes;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SalonServiceTypesRepo extends ElasticsearchRepository<SalonServiceTypes,String>{
    List<SalonServiceTypes> findByPriceGreaterThan(int price);
}
