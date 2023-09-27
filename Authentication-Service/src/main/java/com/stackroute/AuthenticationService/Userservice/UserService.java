package com.stackroute.AuthenticationService.Userservice;

import com.stackroute.AuthenticationService.Exception.EntityNotFoundException;
import com.stackroute.AuthenticationService.UserModel.UserDto;
import com.stackroute.AuthenticationService.UserModel.UserModel;
import com.stackroute.AuthenticationService.UserRepository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements IService {
    @Autowired
    private UserRepository userRepo;

//    @Override
//    public UserModel addUser(UserModel u) {
//        return null;
//    }

    @RabbitListener(queues = "user_auth_queue")
   @Override
    public UserModel addUser(UserDto userDto) {
//        UserModel user=userRepo.save(u);
//        return user;
        UserModel user = new UserModel();
        user.setEmail(userDto.getJsonObject().get("email").toString());
        user.setPassword(userDto.getJsonObject().get("password").toString());
        userRepo.save(user);
        return user;
    }

    @Override
    public Map<String, String> login(UserModel u) throws EntityNotFoundException{
        Map<String,String> token=new HashMap<String,String>();
        try{
            UserModel uu=userRepo.findByEmailAndPassword(u.getEmail(), u.getPassword());
            if(uu!=null)
            {
                token=getJWTToken(u);
                System.out.println("slkfngldkjgkdl");
            }}
        catch (Exception e){
            System.out.println("hsdiudgsijvkdfhiugdh");
            throw new EntityNotFoundException();
        }
        return token;
    }

    @Override
    public List<UserModel> getAllUsers() {
        // TODO Auto-generated method stub
        System.out.println("Hello all");
        List<UserModel> userL=userRepo.findAll();
//        userL.forEach(u->System.out.println(u));
        return userL;
    }
    public Map<String,String> getJWTToken(UserModel u)
    {
        String tok= Jwts.builder().setSubject(u.getEmail()).setIssuedAt(new Date(0)).signWith(SignatureAlgorithm.HS256,"secretkey").compact();
        Map<String,String> tokMap=new HashMap<String,String>();
        tokMap.put("token", tok);
        return tokMap;
    }

}


