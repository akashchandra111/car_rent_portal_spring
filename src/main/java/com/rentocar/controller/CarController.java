// CarController [Author: Akash Chandra]
package com.rentocar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.rentocar.service.CarService;

@RestController
public class CarController {

	@Autowired
	private CarService carService;
}
