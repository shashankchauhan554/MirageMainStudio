package com.stackroute.UserProfileService.model;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;



import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {



	private String email;
	private String fullName;

	private String password;

	private Long phonenumber;


	private Integer age;
	private Urole role;
	private Ugender gender;







}
