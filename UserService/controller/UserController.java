package com.stackroute.UserService.controller;
        import com.stackroute.UserService.Exception.AlreadyFoundException;
        import com.stackroute.UserService.Exception.EntityNotFoundException;
        import com.stackroute.UserService.UserModel.User;
        import com.stackroute.UserService.UserService.UserService;
        import org.hibernate.action.internal.EntityActionVetoException;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
        import java.util.Map;
        import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userv;

        @GetMapping("/movie")
    public String getmovie(){
        return "KGF";
    }
    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody User u) throws AlreadyFoundException
    {

        User u1=userv.addUser(u);
        return new ResponseEntity<>(u1, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User u) throws EntityNotFoundException {
            Map<String,String> map=userv.login(u);
            return new ResponseEntity<>(map,HttpStatus.OK);
    }
    @GetMapping("/users")
    public ResponseEntity<?> getAllUser()
    {
        List<User> users=userv.getAllUsers();
        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }

}



