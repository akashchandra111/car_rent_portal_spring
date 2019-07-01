// CarStatusController [Author: Akash Chandra]
package com.rentocar.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentocar.model.CarStatus;
import com.rentocar.model.Message;
import com.rentocar.model.User;
import com.rentocar.service.CarStatusService;

@RestController
@RequestMapping("/car_status")
public class CarStatusController {

	@Autowired
	private CarStatusService carStatusService;
	
	/*
	Accepts =>	{
	 "carno": "string",
	 "carid": "Car",
	 "userid": "User",
	 "status": "string"
	}
	
	Returns =>	{
	 "message": "string",
	 "status": "string"
	}
	*/
	@PostMapping("/add")
	public Message addCarStatus(@RequestBody CarStatus carStatus, HttpSession userSession)	{
		User user = (User) userSession.getAttribute("user");
		
		if((user != null) && (user.getUserId().equals("0")))	{
			return carStatusService.addNewCarStatus(carStatus);
		}
		else	{
			return new Message("car can't be added user is not admin or null", "failure");
		}
	}
	
	
	/*
	Accepts =>	carNo
	Returns =>	{
	 "carno": "string",
	 "carid": "Car",
	 "userid": "User",
	 "status": "string"
	}
	*/
	@GetMapping("/get/{carNo}")
	public CarStatus getCarStatus(@PathVariable("carNo") String carNo)	{
		return carStatusService.getCar(carNo);
	}
	
	/*
	Accepts =>	carId
	Returns =>	{
	 "carno": "string",
	 "carid": "Car",
	 "userid": "User",
	 "status": "string"
	}
	*/
	@GetMapping("/by_id/get/{carId}")
	public CarStatus getCarStatusById(@PathVariable("carId") String carId)	{
		return carStatusService.getCarById(carId);
	}
	
	/*
	Accepts =>	carNo
	Returns =>	{
	 "message": "string",
	 "status": "string"
	}
	*/
	@PutMapping("/update/{carNo}")
	public Message updateCarStatus(@PathVariable("carNo") String carNo, @RequestBody CarStatus carStatus, HttpSession userSession)	{
		User user = (User) userSession.getAttribute("user");
		
		if(user != null)	return carStatusService.updateCarStatus(carNo, carStatus);
		else	return new Message("user session not found, can't update car status", "failure");
	}
	
	/*
	Accepts => carNo
	Returns =>	{
	 "message": "string",
	 "status": "string"
	}
	 */
	@DeleteMapping("/delete/{carNo}")
	public Message deleteCarStatus(@PathVariable("carNo") String carNo, HttpSession userSession)	{
		User user = (User) userSession.getAttribute("user");
		
		if((user != null) && (user.getUserId().equals("0")))	{
			return carStatusService.deleteCarStatus(carNo);
		}
		else	{
			return new Message("user is not admin or session not found", "failure");
		}
	}
}
