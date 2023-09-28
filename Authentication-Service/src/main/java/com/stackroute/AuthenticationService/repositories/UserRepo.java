package com.stackroute.AuthenticationService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stackroute.AuthenticationService.model.User;

public interface UserRepo extends JpaRepository<User,String> {

    User findByUserEmail(String userEmail);
    User findByUserEmailAndUserPassword(String userEmail, String userPassword);


}
