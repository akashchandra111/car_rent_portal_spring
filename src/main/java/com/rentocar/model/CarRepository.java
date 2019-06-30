// CarRepository [Author: Akash Chandra]
package com.rentocar.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
	public List<Car> findByCarType(String type);
}