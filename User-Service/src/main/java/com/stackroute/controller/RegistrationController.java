package com.stackroute.controller;

import com.stackroute.UserProfileService.model.UserDto;
import com.stackroute.UserProfileService.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("UserRegistration")
public class RegistrationController {
    @Autowired
    UserRegistrationService userregistrationservice;
    @PostMapping("create")
    public ResponseEntity<UserDto> CreateUser(@RequestBody UserDto userdto){
        UserDto createUser = userregistrationservice.CreateUser(userdto);
        return ResponseEntity.ok(createUser);
    }
}
