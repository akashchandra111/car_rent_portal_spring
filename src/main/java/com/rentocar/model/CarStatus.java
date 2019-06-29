// CarStatus [Author: Akash Chandra]
package com.rentocar.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CarStatus {

	@Id
	private String carNo;
	
	@ManyToOne @JoinColumn(foreignKey = @ForeignKey(name = "carId"))
	private Car carId;
	@ManyToOne @JoinColumn(foreignKey = @ForeignKey(name = "userId"))
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
