package com.stackroute.SalonOwnerService.repository;

import com.stackroute.SalonOwnerService.model.SalonOwner;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SalonOwnerRepository extends ElasticsearchRepository<SalonOwner,String> {
//       List<SalonOwner> findByAddr(String addr);

}
