// UserService [Author: Akash Chandra]
package com.rentocar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentocar.model.Message;
import com.rentocar.model.User;
import com.rentocar.model.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public Message addUser(User user) {
		if(userRepo.save(user) != null)	return new Message("new user added", "success");
		else return new Message("user cannot be added", "failure");
	}
	
	public User getUser(String id, String password)	{
		return userRepo.findUser(id, password).orElse(new User());
	}
}
