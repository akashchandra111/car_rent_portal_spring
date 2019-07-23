// CarStatusService [Author: Akash Chandra]
package com.rentocar.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rentocar.model.CarStatus;
import com.rentocar.model.Message;
import com.rentocar.repository.CarStatusRepository;

@Service
public class CarStatusService {

	@Autowired
	private CarStatusRepository carStatusRepo;

	public Message addNewCarStatus(CarStatus carStatus) {
		if(carStatusRepo.save(carStatus) != null)	return new Message("car saved", "success");
		else return new Message("car can't be saved", "failure");
	}
	
	public Message deleteCarStatus(String carNo)	{
		try	{
			carStatusRepo.deleteById(carNo);
			return new Message("car deleted", "success");
		}
		catch(EmptyResultDataAccessException emptyResultSet)	{
			return new Message("car can't be deleted, not found", "failure");
		}
	}
	
	public CarStatus getCar(String carNo)	{
		return carStatusRepo.findById(carNo).orElse(new CarStatus());
	}
	
	public Message updateCarStatus(String carNo, CarStatus updatedCarStatus)	{
		CarStatus carStatus = carStatusRepo.findById(carNo).orElse(new CarStatus());
		
		if(carStatus.getCarNo() != null)	{
			carStatusRepo.deleteById(carNo);
			if(carStatusRepo.save(updatedCarStatus) != null)	return new Message("car updated", "success");
			else	return new Message("car can't update", "failure");
		}
		else	{
			return new Message("car can't update, car number not found", "failure");
		}
	}
	
	public CarStatus getCarById(String carId)	{
//		List<CarStatus> carStatusList = carStatusRepo.findByCarId(carId);
		
//		List<CarStatus> carStatusList = carStatusRepo.findAll().stream()
//				.filter(carStatus -> carStatus.getCarId().equals(carId))
//				.collect(Collectors.toList());
		
		List<CarStatus> carStatusList = carStatusRepo.findAll()
				.stream()
				.filter(carStatus -> carStatus.getCarId().getCarId().equals(carId))
				.collect(Collectors.toList());
		
		if(carStatusList != null && carStatusList.size() >= 1)	{
			// Return only available car or empty
			for(CarStatus carStatus: carStatusList)	{
				if(carStatus.getStatus().equals("available"))	return carStatus;
			}
			return new CarStatus();
		}
		else	{
			return new CarStatus();
		}
	}

	public List<CarStatus> getTotalCar() {
		return carStatusRepo.findAll();
	}

	public List<CarStatus> getTotalBookedOfCarType(String carType) {
//		return carStatusRepo.getTotalBookedOfCarType(carType);
		
//		return carStatusRepo.findCarStatusByCarType(carType)
//				.stream()
//				.filter(carStatus -> carStatus.getStatus().equals("booked"))
//				.collect(Collectors.toList());
		
		return carStatusRepo.findAll()
				.stream()
				.filter(carStatus -> carStatus.getCarId().getCarType().equals(carType))
				.filter(carStatus -> carStatus.getStatus().equals("booked"))
				.collect(Collectors.toList());
	}

	public List<CarStatus> getTotalAvailableOfCarType(String carType) {
//		return carStatusRepo.getTotalAvailableOfCarType(carType);
		
//		return carStatusRepo.findCarStatusByCarType(carType)
//				.stream()
//				.filter(carStatus -> carStatus.getStatus().equals("available"))
//				.collect(Collectors.toList());
		 
		return carStatusRepo.findAll()
				.stream()
				.filter(carStatus -> carStatus.getCarId().getCarType().equals(carType))
				.filter(carStatus -> carStatus.getStatus().equals("available"))
				.collect(Collectors.toList());
	}
}
