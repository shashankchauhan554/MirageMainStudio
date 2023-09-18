package com.stackroute.AuthenticationService.Userservice;

import com.stackroute.AuthenticationService.UserModel.UserModel;

import java.util.List;

public interface IService {
    public UserModel addUser(UserModel u) ;
    public List<UserModel> getAllUsers();
}
