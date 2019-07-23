// UserLogService [Author: Akash Chandra]
package com.rentocar.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentocar.model.Message;
import com.rentocar.model.UserLog;
import com.rentocar.repository.UserLogRepository;

@Service
public class UserLogService {
	
	@Autowired
	private UserLogRepository userLogRepo;

	public Message bookCar(UserLog userLog) {
		if(userLogRepo.save(userLog) != null)	return new Message("car booked", "success");
		else	return new Message("car cannot be booked", "failure");
	}

	public List<UserLog> getBookingHistory(String userId) {
//		List<UserLog> bookingHistory = userLogRepo.findUserLogByUserId(userId);
		List<UserLog> bookingHistory = userLogRepo.findAll().stream()
				.filter(userLog -> userLog.getUserId().getUserId().equals(userId))
				.collect(Collectors.toList());
		
		Collections.sort(bookingHistory, 
			(user1, user2) ->	{
				if(new Long(user1.getStartTime()) > new Long(user2.getStartTime()))	{
					return -1;
				}
				else return +1;
			}
		);
		
		return bookingHistory;
	}
	
	public UserLog getBooking(String userId)	{
		List<UserLog> userLogList = this.getBookingHistory(userId);
		
		if(userLogList != null && userLogList.size() >= 1)	return userLogList.get(0);
		else	return new UserLog();
	}

	public Message deleteBooking(String bookingId) {
		UserLog booking = userLogRepo.findById(bookingId).orElse(new UserLog());
		
		if(booking.getUserLogId() != null)	{
			userLogRepo.deleteById(bookingId);
			return new Message("booking deleted", "success");
		}
		else	{
			return new Message("booking not deleted", "failure");
		}
	}

	public Message updateBooking(String bookingId, UserLog userLog) {
		UserLog booking = userLogRepo.findById(bookingId).orElse(new UserLog());
		
		if(booking.getUserLogId() != null)	{
			userLogRepo.deleteById(bookingId);
			if(userLogRepo.save(userLog) != null)	return new Message("booking updated", "success");
			else	return new Message("booking not updated", "failure");
		}
		else	{
			return new Message("booking not updated, booking id not found", "failure");
		}
	}
}
