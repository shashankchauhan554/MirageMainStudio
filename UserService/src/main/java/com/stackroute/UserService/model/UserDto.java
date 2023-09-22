package com.stackroute.UserService.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "UserRegistration")
public class UserDto {
    @Id
    private String FullName;
    private String Emailid;
    private String password;
    private String Gender;
    private Integer Age;
    private Integer phonenumber;
    private String Role;

    //getters
    public String getFullName() {
        return FullName;
    }
    public String getEmailid(){
        return Emailid;
    }
    public String getGender(){
        return Gender;
    }
    public  Integer getAge(){
        return Age;
    }
    public Integer getPhonenumber(){
        return phonenumber;
    }
    public String getPassword() {
        return password;
    }
    public String getRole(){
        return Role;
    }
    //setters
    public void setFullname(String Fullname){
        this.FullName = Fullname;
    }
    public void setEmailid(String Emailid){
        this.Emailid = Emailid;
    }
    public void setGender(String Gender){
        this.Gender = Gender;
    }
    public void setAge(Integer Age){
        this.Age = Age;
    }
    public void setPhonenumber(Integer phonenumber){
        this.phonenumber = phonenumber;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setRole(String Role){
        this.Role = Role;
    }
}
