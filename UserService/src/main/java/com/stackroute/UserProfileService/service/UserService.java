package com.stackroute.UserProfileService.service;


import com.stackroute.UserProfileService.exception.UserNotFoundException;
import com.stackroute.UserProfileService.model.User;
import java.util.List;
import com.stackroute.UserProfileService.exception.UserAlreadyExistsException;



public interface UserService {
	public User saveUser(User user);
	public List<User> getUser();
	public User getByEmail(String email) throws UserNotFoundException;
	public String deleteUser(String email);
	
	User registerUser(User user) throws UserAlreadyExistsException;
	public User updateUser(User user);
}

