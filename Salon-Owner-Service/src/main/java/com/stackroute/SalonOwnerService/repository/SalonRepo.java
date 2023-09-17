package com.stackroute.SalonOwnerService.repository;

import com.stackroute.SalonOwnerService.model.Salon;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SalonRepo extends ElasticsearchRepository <Salon, String> {
}
