// CarRepository [Author: Akash Chandra]
package com.rentocar.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rentocar.model.Car;

public interface CarRepository extends MongoRepository<Car, String> {
	public List<Car> findByCarType(String type);
}