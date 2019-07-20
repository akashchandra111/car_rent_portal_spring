// UserRepository [Author: Akash Chandra]
package com.rentocar.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rentocar.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	public Optional<User> findUserByDrivingLicenseNum(String drivingLicenseNum);
}
