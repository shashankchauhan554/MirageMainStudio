package com.stackroute.EmailService.Repository;
import com.stackroute.EmailService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, String> {
    User findByToken(String token);
}