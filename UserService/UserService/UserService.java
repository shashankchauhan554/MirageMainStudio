package com.stackroute.UserService.UserService;
import com.stackroute.UserService.Exception.AlreadyFoundException;
import com.stackroute.UserService.UserModel.User;
import com.stackroute.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class UserService implements Iservice {
    @Autowired
    private UserRepository userRepo;

    @Override
    public User addUser(User u) throws AlreadyFoundException {
        Optional<User> user=userRepo.findById(u.getEmail());
        if(user.isPresent())
        {
            throw new AlreadyFoundException();
        }

        System.out.println(user);
        return userRepo.save(u);
    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        System.out.println("Hello all");
        List<User> userL = userRepo.findAll();
//        userL.forEach(u->System.out.println(u));
        return userL;
    }

    @Override
    public Map<String, String> login(User u) {

        Map<String, String> result = new HashMap<>();

        User user = userRepo.findByEmailAndPassword(u.getEmail(), u.getPassword());

        if (user != null) {
            // User found, login successful
            result.put("message", "Login successful");
            result.put("status", "success");
        } else {
            // User not found, login failed
            result.put("message", "Invalid email or password");
            result.put("status", "error");
        }

        return result;

    }
}

