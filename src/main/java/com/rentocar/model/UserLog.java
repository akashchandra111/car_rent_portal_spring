// UserLog [Author: Akash Chandra]
package com.rentocar.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserLog {
	
	@Id
	private String userLogId;
	@ManyToOne @JoinColumn(foreignKey = @ForeignKey(name = "userId"))
	private User userId;
	private String startTime, endTime, currentLocation, dropLocation, secretKey;
	private int totalAmount, paidAmount;
	
	public UserLog()	{	
	}

	public UserLog(String userLogId, User userId, String startTime, String endTime, String currentLocation, String dropLocation,
			String secretKey, int totalAmount, int paidAmount) {
		this.userLogId = userLogId;
		this.userId = userId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.currentLocation = currentLocation;
		this.dropLocation = dropLocation;
		this.secretKey = secretKey;
		this.totalAmount = totalAmount;
		this.paidAmount = paidAmount;
	}

	public String getUserLogId() {
		return userLogId;
	}
	
	public void setUserLogId(String userLogId) {
		this.userLogId = userLogId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}
}
