// CarStatusController [Author: Akash Chandra]
package com.rentocar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.rentocar.service.CarStatusService;

@CrossOrigin()
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
	public Message addCarStatus(@RequestBody CarStatus carStatus)	{
		return carStatusService.addNewCarStatus(carStatus);
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
	public Message updateCarStatus(@PathVariable("carNo") String carNo, @RequestBody CarStatus carStatus)	{
		return carStatusService.updateCarStatus(carNo, carStatus);
	}
	
	/*
	Accepts => carNo
	Returns =>	{
	 "message": "string",
	 "status": "string"
	}
	 */
	@DeleteMapping("/delete/{carNo}")
	public Message deleteCarStatus(@PathVariable("carNo") String carNo)	{
		return carStatusService.deleteCarStatus(carNo);
	}
	
	@GetMapping("/total")
	public List<CarStatus> getTotalCar()	{
		return carStatusService.getTotalCar();
	}
	
	@GetMapping("/booked/{carType}")
	public List<CarStatus> getTotalBookedOfCarType(@PathVariable("carType") String carType)	{
		return carStatusService.getTotalBookedOfCarType(carType);
	}
	
	@GetMapping("/available/{carType}")
	public List<CarStatus> getTotalAvailableOfCarType(@PathVariable("carType") String carType)	{
		return carStatusService.getTotalAvailableOfCarType(carType);
	}
}
