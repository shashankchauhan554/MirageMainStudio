package com.stackroute.UserProfileService.service;
import java.util.List;
import java.util.Optional;


import com.stackroute.UserProfileService.exception.UserNotFoundException;
import com.stackroute.UserProfileService.producer.UserDTO;
import org.json.simple.JSONObject;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.UserProfileService.exception.UserAlreadyExistsException;
import com.stackroute.UserProfileService.model.*;
import com.stackroute.UserProfileService.repository.UserRepository;


@Service
public class UserServiceimpl implements UserService{

	@Autowired
	UserRepository userRepository;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private DirectExchange directExchange;
	

	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getUser() {
		return userRepository.findAll();
	}

	@Override
	public String deleteUser(String email) {
		User del = userRepository.findById(email).get();
		userRepository.delete(del);
		return "Deleted";
	}

	@Override
	public User updateUser(User user) {

		return userRepository.findAndModifyByEmail(user.getEmail(), user);
	}

	@Override
	public User getByEmail(String email) throws UserNotFoundException {
		Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmail(email));
		if (userOptional.isPresent()) {
			return userOptional.get();
		} else {
			throw new UserNotFoundException("User not found!");
		}
	}
	
	
	@Override
	 public User registerUser(User user) throws UserAlreadyExistsException {
		Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmail(user.getEmail()));

	     if (userOptional.isPresent()) {
			 System.out.println(userOptional.get());
	         throw new UserAlreadyExistsException("User Already Exists!");
	     } else {
			 User savedUser = userRepository.save(user);

	         JSONObject authobj = new JSONObject();
	 
	         authobj.put("userEmail", user.getEmail());
	         authobj.put("userPassword", user.getPassword());
	         authobj.put("userRole", user.getRole());
	         
	 
	         JSONObject emailObj = new JSONObject();
	         emailObj.put("userEmail", user.getEmail());
	         emailObj.put("userName", user.getFullName());
	 
	         UserDTO authDTO = new UserDTO(authobj);
	         rabbitTemplate.convertAndSend(directExchange.getName(), "thisIsAuthKey", authDTO);

	         UserDTO emailDTO = new UserDTO(emailObj);
	         rabbitTemplate.convertAndSend(directExchange.getName(),"thisIsEmailKey",emailDTO);
	       return savedUser;
	     }

	 }

}


