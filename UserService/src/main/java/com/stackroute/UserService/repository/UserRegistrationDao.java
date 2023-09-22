package com.stackroute.UserService.Repository;

import com.stackroute.UserService.model.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRegistrationDao extends MongoRepository<UserDto, String> {
    //Queries
}
