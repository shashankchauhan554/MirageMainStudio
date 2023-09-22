package com.stackroute.UserService.Controller;
import com.stackroute.UserService.model.UserDto;
import com.stackroute.UserService.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("UserRegistration")
public class UserRegistrationController {
    @Autowired
    UserRegistrationService userregistrationservice;
    @PostMapping("/create")
    public ResponseEntity<UserDto> CreateUser(@RequestBody UserDto userdto){
        UserDto createUser = userregistrationservice.CreateUser(userdto);
        return ResponseEntity.ok(createUser);
    }
}
