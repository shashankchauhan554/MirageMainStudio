package com.stackroute.SalonOwnerService.repository;

import com.stackroute.SalonOwnerService.model.SalonOwner;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonOwnerRepo extends ElasticsearchRepository<SalonOwner,String> {
    //    List<HotelOwner> findByAddr(String addr);

}
