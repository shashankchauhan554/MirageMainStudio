package com.stackroute.UserService.controller;

import com.stackroute.UserService.exception.UserAlreadyExist;
import com.stackroute.UserService.model.UserDto;
import com.stackroute.UserService.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserRegistrationController {

    @Autowired
    private Userservice userv;

    @GetMapping("/movie")
    public String movie(){
        return "KGF";
    }

    @PostMapping("/user")
    public ResponseEntity<?>addUser(@RequestBody UserDto u) throws UserAlreadyExist {
        UserDto user=userv.addUser(u);
        return  new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/users")

    public ResponseEntity<?>getAllUsers()
    {
        List<UserDto> user=userv.getAllUsers();
        return  new ResponseEntity< List<UserDto> >(user, HttpStatus.OK);
    }

}
