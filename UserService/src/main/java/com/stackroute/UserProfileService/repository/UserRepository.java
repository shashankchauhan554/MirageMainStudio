package com.stackroute.UserProfileService.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.UserProfileService.model.*;
@Repository
	public interface UserRepository extends MongoRepository<User,String> {
	
	    User findByEmail(String email);


	}


