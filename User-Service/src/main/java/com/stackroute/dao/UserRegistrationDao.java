package com.stackroute.dao;


import com.stackroute.UserProfileService.model.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRegistrationDao extends MongoRepository<UserDto, String> {

}


