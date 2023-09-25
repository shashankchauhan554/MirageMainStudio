package com.stackroute.UserService.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class UserDto {
    @Id
    private int id;

    private String FullName;

    public UserDto() {
    }

    public UserDto(int id, String fullName, String emailid, String password, Ugender gender, Urole role, Integer age, long phonenumber) {
        this.id = id;
        FullName = fullName;
        Emailid = emailid;
        this.password = password;
        Gender = gender;
        this.role = role;
        Age = age;
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", FullName='" + FullName + '\'' +
                ", Emailid='" + Emailid + '\'' +
                ", password='" + password + '\'' +
                ", Gender=" + Gender +
                ", role=" + role +
                ", Age=" + Age +
                ", phonenumber=" + phonenumber +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getEmailid() {
        return Emailid;
    }

    public void setEmailid(String emailid) {
        Emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Ugender getGender() {
        return Gender;
    }

    public void setGender(Ugender gender) {
        Gender = gender;
    }

    public Urole getRole() {
        return role;
    }

    public void setRole(Urole role) {
        this.role = role;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    private String Emailid;
    private String password;
    private Ugender Gender;
    private Urole role;
    private Integer Age;
    private long phonenumber;










}
