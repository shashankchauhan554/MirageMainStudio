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

    private String FullName;
    private String Email;
    private String password;
    private Ugender Gender;
    private Urole role;
    private Integer Age;
    private long phonenumber;


    public UserDto(JSONObject authobj){

    }

}
