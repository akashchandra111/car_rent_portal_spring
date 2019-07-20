// UserService [Author: Akash Chandra]
package com.rentocar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rentocar.model.Message;
import com.rentocar.model.User;
import com.rentocar.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public Message addUser(User user) {
		if(userRepo.save(user) != null)	return new Message("new user added", "success");
		else return new Message("user cannot be added", "failure");
	}
	
	public User getUser(String id, String password)	{
		return userRepo.findAll()
				.stream()
				.filter(
						(user) ->	{
							if((user.getUserId().equals(id) || 
									user.getUserName().equals(id) || 
									user.getEmail().equals(id) || 
									user.getMobileNum().equals(id)) && 
							user.getPassword().equals(password))	return true;
							else return false;
						}
				).findFirst().orElse(new User());
	}

	public Message removeUser(String userId) {
		try	{
			userRepo.deleteById(userId);
			return new Message("user deleted", "success");
		}
		catch(EmptyResultDataAccessException emptyResultData)	{
			return new Message("user not found", "failure");
		}
	}

	public Message updateUser(User user) {
//		User userToRemove = userRepo.findUser(user.id, password).orElse(new User());
		
		if(user.getUserId()!=null)	{
			userRepo.deleteById(user.getUserId());
			userRepo.save(user);
			return new Message("user updated", "success");
		}
		else	{
			return new Message("user not found", "failure");
		}
	}

	public long getTotalUsers() {
		return userRepo.findAll().stream().count();
	}

	public User getUserByDrivingLicenseNo(String drivingLicenseNum) {
		return userRepo.findUserByDrivingLicenseNum(drivingLicenseNum).orElse(new User());
	}
}
