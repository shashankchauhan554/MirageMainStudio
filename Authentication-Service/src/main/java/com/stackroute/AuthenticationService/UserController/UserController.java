package com.stackroute.AuthenticationService.UserController;

import com.stackroute.AuthenticationService.UserModel.UserModel;
import com.stackroute.AuthenticationService.Userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userv;

//    @GetMapping("/movie")
//    public String getmovie(){
//        return "KGF";
//    }
    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody UserModel u)
    {
        UserModel u1=userv.addUser(u);
        return new ResponseEntity<>(u1, HttpStatus.CREATED);
    }
    @GetMapping("/users")
    public ResponseEntity<?> getAllUser()
    {
        List<UserModel> users=userv.getAllUsers();
        return new ResponseEntity<List<UserModel>>(users,HttpStatus.OK);
    }

}


