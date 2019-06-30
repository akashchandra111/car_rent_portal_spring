// UserLogController [Author: Akash Chandra]
package com.rentocar.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rentocar.model.Message;
import com.rentocar.model.User;
import com.rentocar.model.UserLog;
import com.rentocar.service.UserLogService;

@RestController
public class UserLogController {

	@Autowired
	private UserLogService userLogService;
	
	/*
	 Accepts =>	{
	  "userLogId": "string",
	  "userId": "User",
	  "startTime": "string",
	  "endTime": "string",
	  "currentLocation": "string",
	  "dropLocation": "string",
	  "secretKey": "string",
	  "totalAmount": "number",
	  "paidAmount" "number",
	 }
	 Returns =>	{
	  "message": "string",
	  "status": "string"
	 }
	*/
	@PostMapping("/add_booking")
	public Message bookCar(@RequestBody UserLog userLog, HttpSession userSession)	{
		User user = (User) userSession.getAttribute("user");
		
		if(user != null)	{
			return userLogService.bookCar(userLog);
		}
		else	{
			return new Message("user session not found, car booking failed", "failure");
		}
	}
	
	/*
	 Returns => {
	  "userLogId": "string",
	  "userId": "User",
	  "startTime": "string",
	  "endTime": "string",
	  "currentLocation": "string",
	  "dropLocation": "string",
	  "secretKey": "string",
	  "totalAmount": "number",
	  "paidAmount" "number",
	 }
	 */
	@GetMapping("/latest_booking")
	public UserLog getBooking(HttpSession userSession)	{
		User user = (User) userSession.getAttribute("user");
		
		if(user != null)	{
			return userLogService.getBooking(user.getUserId());
		}
		else	{
			return new UserLog();
		}
	}
	
	/*
	 Returns => [{
	  "userLogId": "string",
	  "userId": "User",
	  "startTime": "string",
	  "endTime": "string",
	  "currentLocation": "string",
	  "dropLocation": "string",
	  "secretKey": "string",
	  "totalAmount": "number",
	  "paidAmount" "number",
	 }]
	 */
	@GetMapping("/book_history")
	public List<UserLog> getHistory(HttpSession userSession)	{
		User user = (User) userSession.getAttribute("user");
		
		if(user != null)	{
			return userLogService.getBookingHistory(user.getUserId());
		}
		else	{
			return Arrays.asList(new UserLog());
		}
	}
	
	/*
	Accepts =>	bookingId
	Returns =>	{
	 "message": "string",
	 "status": "string"
	}
	 */
	@DeleteMapping("/cancel_booking/{bookingId}")
	public Message deleteBooking(@PathVariable("bookingId") String bookingId, HttpSession userSession)	{
		User user = (User) userSession.getAttribute("user");
		
		if(user != null)	{
			return userLogService.deleteBooking(bookingId);
		}
		else	{
			return new Message("user session not found, can't delete", "failure");
		}
	}
	
	/*
	Accepts =>	{
	  "userLogId": "string",
	  "userId": "User",
	  "startTime": "string",
	  "endTime": "string",
	  "currentLocation": "string",
	  "dropLocation": "string",
	  "secretKey": "string",
	  "totalAmount": "number",
	  "paidAmount" "number",
	 }
	 
	 Returns =>	{
	  "message": "string",
	  "status": "string"
	 }
	 */
	@PutMapping("/update_booking/{bookingId}")
	public Message updateBooking(@PathVariable("bookingId")String bookingId, @RequestBody UserLog userLog, HttpSession userSession)	{
		User user = (User) userSession.getAttribute("user");
		
		if(user != null)	{
			return userLogService.updateBooking(bookingId, userLog);
		}
		else	{
			return new Message("user session not found, can't udpate", "failure");
		}
	}
}
