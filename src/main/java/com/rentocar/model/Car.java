// CarStatusRepository [Author: Akash Chandra]
package com.rentocar.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Car")
public class Car implements Serializable	{
	@Id
	private String carId;
	private String carType, mileage, seaters, description, carName, imgPath;
	private int cost;
	
	public Car()	{	
	}

	public Car(String carId, String carType, String mileage, String seaters, String description, String carName,
			String imgPath, int cost) {
		this.carId = carId;
		this.carType = carType;
		this.mileage = mileage;
		this.seaters = seaters;
		this.description = description;
		this.carName = carName;
		this.imgPath = imgPath;
		this.cost = cost;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getSeaters() {
		return seaters;
	}

	public void setSeaters(String seaters) {
		this.seaters = seaters;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
