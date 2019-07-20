// CarService [Author: Akash Chandra]
package com.rentocar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rentocar.model.Car;
import com.rentocar.model.Message;
import com.rentocar.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepo;

	public Message addCar(Car car) {
		if(carRepo.save(car) != null)	return new Message("car added", "success");
		else	return new Message("car is not added", "failure");
	}

	public Car getCar(String carId) {
		return carRepo.findById(carId).orElse(new Car());
	}

	public List<Car> getCarsByType(String type) {
		return carRepo.findByCarType(type);
	}

	public Message updateCar(String carId, Car updatedCar) {
		Car car = carRepo.findById(carId).orElse(new Car());
		
		if(car.getCarId() != null)	{
			carRepo.deleteById(carId);
			carRepo.save(updatedCar);
			return new Message("car updated", "success");
		}
		else	{
			return new Message("car can't be updated, id not found", "failure");
		}
	}

	public Message deleteCar(String carId) {
		try	{
			carRepo.deleteById(carId);
			return new Message("car deleted", "success");
		}
		catch(EmptyResultDataAccessException emptyResultData)	{
			return new Message("car can't be deleted, id not found", "failure");
		}
	}
}
