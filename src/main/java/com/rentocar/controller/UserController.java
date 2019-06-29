// UserController [Author: Akash Chandra]
package com.rentocar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rentocar.model.Login;
import com.rentocar.model.Message;
import com.rentocar.model.User;
import com.rentocar.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	/*  
	 Accepts => {
	  "userId": "string",
	  "firstName": "string",
	  "lastName": "string",
	  "mobileNum": "string",
	  "govtIdType": "string",
	  "govtIdNum": "string",
	  "userName": "string",
	  "password": "string",
	  "email": "string",
	  "wallet": "number"
	} 
	 Returns =>	{
	  "message": "string",
	  "status": "string"
	 }
	*/
	@PostMapping("/register")
	public Message addUser(@RequestBody User user)	{
		return userService.addUser(user);
	}
	
	/*
	 Accepts => { 
	 "id": "string",
	 "password": "string"
	 }
	 Returns => {
	  "userId": "string",
	  "firstName": "string",
	  "lastName": "string",
	  "mobileNum": "string",
	  "govtIdType": "string",
	  "govtIdNum": "string",
	  "userName": "string",
	  "password": "string",
	  "email": "string",
	  "wallet": "number"
	 } 
	*/
	@PostMapping("/login")
	public User getUser(@RequestBody Login userLogin)	{
		String userId = userLogin.getId();
		String userPass = userLogin.getPassword();
		return userService.getUser(userId, userPass);
	}
}
