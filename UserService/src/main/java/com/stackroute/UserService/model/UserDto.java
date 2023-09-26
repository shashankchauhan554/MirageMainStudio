package com.stackroute.UserService.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.json.JsonObject;
import org.json.simple.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
public class UserDto {


    private String fullName;
    private String email;
    private String password;
    private Ugender gender;
    private Urole role;
    private Integer age;
    private long phonenumber;


    public UserDto(JSONObject authobj){
    }

    public UserDto(String fullName, String email, String password) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public UserDto(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }
}


