package com.stackroute.UserService.service;

import com.stackroute.UserService.model.UserDto;

import java.util.List;

public interface Iservice {
    public UserDto addUser(UserDto u);
    public List<UserDto> getAllUsers();

}
