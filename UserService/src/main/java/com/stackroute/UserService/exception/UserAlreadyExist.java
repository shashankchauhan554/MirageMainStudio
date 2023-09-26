package com.stackroute.UserService.exception;


import javax.naming.AuthenticationException;

public class UserAlreadyExist extends AuthenticationException {

    public UserAlreadyExist(final String msg) {
        super(msg);
    }

}