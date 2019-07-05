// CarController [Author: Akash Chandra]
package com.rentocar.controller;

import java.util.List;

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

import com.rentocar.model.Car;
import com.rentocar.model.Message;
import com.rentocar.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;

	/*
	Accepts => {
	 "carId": "string",
	 "carType": "string",
	 "mileage": "string",
	 "seaters": "string",
	 "description": "string",
	 "carName": "string",
	 "imgPath": "string",
	 "cost": "number"
	}
	
	Returns =>	{
	 "message": "string",
	 "status": "string"
	}
	 */
	@PostMapping("/add")
	public Message addCar(@RequestBody Car car)	{
			return carService.addCar(car);
	}
	
	/*
	Accepts => carId
	
	Returns =>	{
	 "carId": "string",
	 "carType": "string",
	 "mileage": "string",
	 "seaters": "string",
	 "description": "string",
	 "carName": "string",
	 "imgPath": "string",
	 "cost": "number"
	}
	 */
	@GetMapping("/get/{carId}")
	public Car getCar(@PathVariable("carId") String carId)	{
		return carService.getCar(carId);
	}
	
	/*
	Accepts => carType
	
	Returns =>	[{
	 "carId": "string",
	 "carType": "string",
	 "mileage": "string",
	 "seaters": "string",
	 "description": "string",
	 "carName": "string",
	 "imgPath": "string",
	 "cost": "number"
	}]
	 */
	@GetMapping("/type/{type}")
	public List<Car> getCarsByType(@PathVariable("type") String type)	{
		return carService.getCarsByType(type);
	}
	
	/*
	Accepts => carId
	
	Returns => {
	 "message": "string",
	 "status" : "string"
	}
	 */
	@PutMapping("/update/{carId}")
	public Message updateCar(@PathVariable("carId") String carId, @RequestBody Car car, HttpSession userSession)	{
			return carService.updateCar(carId, car);
	}
	
	/*
	Accepts => carId
	
	Returns =>	{
	 "message": "string",
	 "status": "string"
	}
	 */
	@DeleteMapping("/delete/{carId}")
	public Message deleteCar(@PathVariable("carId") String carId)	{
			return carService.deleteCar(carId);
	}
}
