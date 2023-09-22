package com.stackroute.SalonOwnerService.repository;

import com.stackroute.SalonOwnerService.model.Category;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends ElasticsearchRepository<Category,String>{
    List<Category> findByPriceGreaterThan(int price);
}
