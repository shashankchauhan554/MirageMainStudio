package com.stackroute.AuthenticationService.Userservice;

import com.stackroute.AuthenticationService.Exception.EntityNotFoundException;
import com.stackroute.AuthenticationService.UserModel.UserDto;
import com.stackroute.AuthenticationService.UserModel.UserModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.util.List;
import java.util.Map;

public interface IService {
//    public UserModel addUser(UserModel u);

    @RabbitListener(queues = "user_auth_queue")
    UserModel addUser(UserDto userDto);

    public Map<String,String> login(UserModel u) throws EntityNotFoundException;
    public List<UserModel> getAllUsers();
}
