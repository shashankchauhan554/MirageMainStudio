package com.stackroute.AuthenticationService.UserModel;

import javax.persistence.Entity;
import javax.persistence.Id;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.data.annotation.Id;
//
//import javax.persistence.Entity;
//@AllArgsConstructor
//@Getter
//@Setter
//@NoArgsConstructor
@Entity
public class UserModel {
    @Id
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public UserModel() {
    }

    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


