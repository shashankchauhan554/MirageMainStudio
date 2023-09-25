package com.stackroute.UserService.service;

import com.stackroute.UserService.model.UserDto;
import com.stackroute.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userservice implements Iservice{
    @Autowired
    private UserRepository urepo;

    @Override
    public UserDto addUser(UserDto u) {
        UserDto user=urepo.save(u);
        return user;
    }

    @Override
    public List<UserDto> getAllUsers() {
        System.out.println("Hello all");
        List<UserDto> userL=urepo.findAll();
//        userL.forEach(u->System.out.println(u));
        return userL;
    }
}
