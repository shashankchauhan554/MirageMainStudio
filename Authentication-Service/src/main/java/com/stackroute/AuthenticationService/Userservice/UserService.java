package com.stackroute.AuthenticationService.Userservice;

import com.stackroute.AuthenticationService.UserModel.UserModel;
import com.stackroute.AuthenticationService.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements IService {
    @Autowired
    private UserRepository userRepo;

   @Override
    public UserModel addUser(UserModel u) {
        UserModel user=userRepo.save(u);
        return user;
    }
    @Override
    public List<UserModel> getAllUsers() {
        // TODO Auto-generated method stub
        System.out.println("Hello all");
        List<UserModel> userL=userRepo.findAll();
//        userL.forEach(u->System.out.println(u));
        return userL;
    }

}


