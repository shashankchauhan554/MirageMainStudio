package com.stackroute.UserService.repository;

import com.stackroute.UserService.model.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends MongoRepository<UserDto,String> {

    boolean existsByEmail(String email);
}
