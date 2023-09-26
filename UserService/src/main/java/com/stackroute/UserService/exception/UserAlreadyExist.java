package com.stackroute.UserService.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.CONFLICT,reason = "User already exist")
public class UserAlreadyExist extends Exception {

//    public UserAlreadyExist(final String msg) {
//        super(msg);
//    }

}