package com.stackroute.UserService.repository;

import com.stackroute.UserService.UserModel.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    public User findByEmailAndPassword(String email,String password);
}
