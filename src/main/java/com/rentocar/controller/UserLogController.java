// UserLogController [Author: Akash Chandra]
package com.rentocar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentocar.model.Message;
import com.rentocar.model.UserLog;
import com.rentocar.service.UserLogService;

@RestController
@RequestMapping("/user_log")
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
	@PostMapping("/add")
	public Message bookCar(@RequestBody UserLog userLog)	{
			return userLogService.bookCar(userLog);
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
	@GetMapping("/latest/{userId}")
	public UserLog getBooking(@PathVariable("userId") String userId)	{
			return userLogService.getBooking(userId);
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
	@GetMapping("/history/{userId}")
	public List<UserLog> getHistory(@PathVariable("userId") String userId)	{
		return userLogService.getBookingHistory(userId);
	}
	
	/*
	Accepts =>	bookingId
	Returns =>	{
	 "message": "string",
	 "status": "string"
	}
	 */
	@DeleteMapping("/cancel/{bookingId}")
	public Message deleteBooking(@PathVariable("bookingId") String bookingId)	{
		return userLogService.deleteBooking(bookingId);
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
	@PutMapping("/update/{bookingId}")
	public Message updateBooking(@PathVariable("bookingId")String bookingId, @RequestBody UserLog userLog)	{
		return userLogService.updateBooking(bookingId, userLog);
	}
}
