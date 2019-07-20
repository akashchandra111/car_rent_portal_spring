// CarStatus [Author: Akash Chandra]
package com.rentocar.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="car_status")
public class CarStatus implements Serializable {
	@Id
	private String carNo;
	
	private Car carId;
	private User userId;
	private String status;
	
	public CarStatus()	{
	}
	
	public CarStatus(String carNo, Car carId, User userId, String status) {
		this.carNo = carNo;
		this.carId = carId;
		this.userId = userId;
		this.status = status;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public Car getCarId() {
		return carId;
	}

	public void setCarId(Car carId) {
		this.carId = carId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
