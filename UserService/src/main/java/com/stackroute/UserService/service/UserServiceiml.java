package com.stackroute.UserService.service;


import com.stackroute.UserService.exception.UserAlreadyExist;
import com.stackroute.UserService.model.UserDto;
import com.stackroute.UserService.repository.UserRepository;
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
    private DirectExchange directExchange;

    @Autowired
    private UserRepository userRepository;



    public UserDto registerUser(UserDto user) throws UserAlreadyExist {
        Optional<Boolean> userDtoOptional = Optional.ofNullable(
                userRepository.existsByEmail(user.getEmail())
        );

        if (userDtoOptional.isPresent()) {
            System.out.println(userDtoOptional.get());
            throw new UserAlreadyExist ("User Already Exists");
        } else {

            UserDto saveduser = userRepository.save(user);
            JSONObject authobj = new JSONObject();

            authobj.put("userEmail", user.getEmail());
            authobj.put("userPassword", user.getPassword());
            authobj.put("userFullname", user.getFullName());

            UserDto authDto = new UserDto(authobj);
            rabbitTemplate.convertAndSend(directExchange.getName(), "thisisAuthkey", authDto);

            JSONObject emailobj = new JSONObject();

            emailobj.put("userEmail", user.getEmail());
            emailobj.put("userFullname", user.getFullName());

            UserDto emailDto = new UserDto(emailobj);
            rabbitTemplate.convertAndSend(directExchange.getName(), "thisisEmailkey", emailDto);
            return saveduser;

        }
    }
}