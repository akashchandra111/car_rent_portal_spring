// CarStatusService [Author: Akash Chandra]
package com.rentocar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentocar.model.CarStatusRepository;

@Service
public class CarStatusService {

	@Autowired
	private CarStatusRepository carStatusRepo;
}
