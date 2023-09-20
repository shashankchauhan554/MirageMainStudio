package com.stackroute.SalonOwnerService.repository;

import com.stackroute.SalonOwnerService.model.Salon;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SalonRepo extends ElasticsearchRepository <Salon, String> {
    Salon findByHotelName(String med);
    Salon findByHotelAddress(String med);
    List<Salon> findByLocation(String location);
    List<Salon> findByPriceGreaterThan(int price);


}