package com.stackroute.SalonOwnerService.repository;

import com.stackroute.SalonOwnerService.model.Salon;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalonRepository extends ElasticsearchRepository <Salon, String> {
    List<Salon> findBySalonName(String med);
    List<Salon> findByCity(String med);

    Optional<Salon> findByEmail(String med);
//    List<Salon> findByLocation(String location);
//    List<Salon> findByPriceGreaterThan(int price);

}