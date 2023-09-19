package com.stackroute.UserService.UserModel;



import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;


@Entity(name = "user")
public class User {

    public User() {
    }

    public User(String email, String password, String fullName, long mobile, Urole role, Ugender gender) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.mobile = mobile;
        this.role = role;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", mobile=" + mobile +
                ", role=" + role +
                ", gender=" + gender +
                '}';
    }

    @Id
    private String email;
    private String password;

    public String getEmail() {
        return email;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public Urole getRole() {
        return role;
    }

    public void setRole(Urole role) {
        this.role = role;
    }

    public Ugender getGender() {
        return gender;
    }

    public void setGender(Ugender gender) {
        this.gender = gender;
    }

    private String fullName;


    private long mobile;

    @Enumerated(EnumType.STRING)
    private Urole role;

    @Enumerated(EnumType.STRING)

    private Ugender gender;
}
