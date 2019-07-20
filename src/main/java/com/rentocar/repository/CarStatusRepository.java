package com.rentocar.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rentocar.model.CarStatus;

public interface CarStatusRepository extends MongoRepository<CarStatus, String>{
}
