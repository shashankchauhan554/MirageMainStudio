package com.stackroute.service;

import com.stackroute.UserService.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    @Autowired
    private com.stackroute.UserService.dao.UserRegistartionDao userregistrationdao;

    public UserDto CreateUser(UserDto userDto) {
        return userregistrationdao.save(userDto);
    }
}
