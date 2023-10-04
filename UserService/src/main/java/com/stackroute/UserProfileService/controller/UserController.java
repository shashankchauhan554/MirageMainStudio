package com.stackroute.UserProfileService.controller;
import java.util.List;

import com.stackroute.UserProfileService.exception.UserAlreadyExistsException;
import com.stackroute.UserProfileService.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.stackroute.UserProfileService.model.User;
import com.stackroute.UserProfileService.service.*;


@RestController
@RequestMapping("/user")
public class UserController{
	@Autowired
    UserService userService;
    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/api/register")
    public User register(@RequestBody User user) throws UserAlreadyExistsException {
    	System.out.println(user);
    	return this.userService.registerUser(user);
    	
    	
    }
    
    @GetMapping("/api/getAll")
    public List<User> getallusers(){
    	return this.userService.getUser();
    }


    @GetMapping("/api/getByEmail/{email}")
    public User getUserByEmail(@PathVariable("email") String userEmail) throws UserNotFoundException {

        return this.userService.getByEmail(userEmail);
    }
    
    @PutMapping("api/update")
    public User UpdateUser(@RequestBody User user) {
    	return this.userService.updateUser(user);
    }
      
}