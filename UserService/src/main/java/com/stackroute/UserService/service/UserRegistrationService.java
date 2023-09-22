package com.stackroute.UserService.service;
import com.stackroute.UserService.Repository.UserRegistrationDao;
import com.stackroute.UserService.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    @Autowired
    private UserRegistrationDao userregistrationdao;

    public UserDto CreateUser(UserDto userDto) {
        return userregistrationdao.save(userDto);
    }
}
