package com.stackroute.UserService.UserService;

import com.stackroute.UserService.Exception.AlreadyFoundException;
import com.stackroute.UserService.UserModel.User;
import org.hibernate.action.internal.EntityActionVetoException;

import java.util.List;
import java.util.Map;

public interface Iservice {
    public User addUser(User u) throws AlreadyFoundException;
    public Map<String,String> login(User u) throws EntityActionVetoException;
    public List<User> getAllUsers();
}

