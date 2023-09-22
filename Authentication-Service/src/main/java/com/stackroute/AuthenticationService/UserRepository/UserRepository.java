package com.stackroute.AuthenticationService.UserRepository;
//package com.stackroute.userauthenticationservice.Repository;
//import com.stackroute.userauthenticationservice.User.User;
import com.stackroute.AuthenticationService.UserModel.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<UserModel,String> {
    public UserModel findByEmailAndPassword(String email,String password);
//    public User findByEmailAndPassword(String email,String password);
}
