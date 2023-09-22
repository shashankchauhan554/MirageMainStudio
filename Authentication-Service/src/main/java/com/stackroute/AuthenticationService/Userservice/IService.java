package com.stackroute.AuthenticationService.Userservice;

import com.stackroute.AuthenticationService.Exception.EntityNotFoundException;
import com.stackroute.AuthenticationService.UserModel.UserModel;

import java.util.List;
import java.util.Map;

public interface IService {
    public UserModel addUser(UserModel u) ;
    public Map<String,String> login(UserModel u) throws EntityNotFoundException;
    public List<UserModel> getAllUsers();
}
