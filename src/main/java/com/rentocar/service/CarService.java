// CarService [Author: Akash Chandra]
package com.rentocar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentocar.model.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepo;
}
