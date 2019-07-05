// UserController [Author: Akash Chandra]
package com.rentocar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rentocar.model.Login;
import com.rentocar.model.Message;
import com.rentocar.model.User;
import com.rentocar.service.UserService;

@RestController
@RequestMapping("/user")
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
	
//	/*
//	 Accepts => { 
//	 "id": "string",
//	 "password": "string"
//	 }
//	 Returns => {
//	  "userId": "string",
//	  "firstName": "string",
//	  "lastName": "string",
//	  "mobileNum": "string",
//	  "govtIdType": "string",
//	  "govtIdNum": "string",
//	  "userName": "string",
//	  "password": "string",
//	  "email": "string",
//	  "wallet": "number"
//	 } 
//	*/
//	@PostMapping("/login")
//	public User getUser(@RequestBody Login userLogin, HttpSession userSession)	{
//		String userId = userLogin.getId();
//		String userPass = userLogin.getPassword();
//		
//		User user = userService.getUser(userId, userPass);
//		
//		if(user.getUserId() != null)	userSession.setAttribute("user", user);
//		return user;
//	}
	
	/*
	 Accepts => { 
	 "id": "string",
	 "password": "string"
	 }
	 Returns => {
	  "message": "string",
	  "status": "string"
	 } 
	*/
	@DeleteMapping("/deregister")
	public Message deRegisterUser(@RequestBody Login userLogin)	{
		return userService.removeUser(userLogin.getId(), userLogin.getPassword());
	}
	
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
	 Returns => {
	  "message": "string",
	  "status": "string"
	 } 
	*/
	@PutMapping("/update")
	public Message updateUser(@RequestBody User updatedUser)	{
		return userService.updateUser(updatedUser);
	}
	
//	/*
//	 Returns => {
//	  "message": "string",
//	  "status": "string"
//	 } 
//	*/
//	@PostMapping("/logout")
//	public Message logoutUser(HttpSession userSession)	{
//		User user = (User) userSession.getAttribute("user");
//		if(user != null)	{
//			userSession.invalidate();
//			return new Message("user logout", "success"); 
//		}
//		else	{
//			return new Message("no user found to logout", "failure");
//		}
//	}
	
	/*
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
	@PostMapping("/get_user")
	public User getUser(@RequestBody Login login)	{
		return userService.getUser(login.getId(), login.getPassword());
	}
}
