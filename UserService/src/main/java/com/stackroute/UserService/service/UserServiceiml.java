package com.stackroute.UserService.service;


import com.stackroute.UserService.exception.UserAlreadyExist;
import com.stackroute.UserService.model.UserDto;
import com.stackroute.UserService.repository.UserRepository;
import org.apache.catalina.User;
import org.json.simple.JSONObject;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceiml {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange exchange;

    @Autowired
    private UserRepository userRepository;



    public UserDto registerUser(UserDto user) throws UserAlreadyExist {
        Optional<UserDto> userDtoOptional = userRepository.findById(user.getEmail());
        if (!userDtoOptional.isEmpty()) {
            System.out.println(userDtoOptional.get());
            throw new UserAlreadyExist ();
        } else {

            UserDto saveduser = userRepository.save(user);
//            JSONObject authobj = new JSONObject();
//
//            authobj.put("userEmail", user.getEmail());
//            authobj.put("userPassword", user.getPassword());
//            authobj.put("userFullname", user.getFullName());
//
//            UserDto authDto = new UserDto(authobj);
//            rabbitTemplate.convertAndSend(directExchange.getName(), "thisisAuthkey", authDto);
//
//            JSONObject emailobj = new JSONObject();
//
//            emailobj.put("userEmail", user.getEmail());
//            emailobj.put("userFullname", user.getFullName());
//
//            UserDto emailDto = new UserDto(emailobj);
//            rabbitTemplate.convertAndSend(directExchange.getName(), "thisisEmailkey", emailDto);
//            return saveduser;
            UserDto userdata = new UserDto(user.getFullName(),user.getEmail(),user.getPassword());
            rabbitTemplate.convertAndSend(exchange.getName(),"user_routing", userdata);

            UserDto useremaildata = new UserDto(user.getFullName(),user.getEmail());
            rabbitTemplate.convertAndSend(exchange.getName(),"user_routing", useremaildata);
            return saveduser;
        }
    }
}