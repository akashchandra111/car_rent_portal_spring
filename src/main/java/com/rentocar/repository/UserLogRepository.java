// UserLogRepository [Author: Akash Chandra]
package com.rentocar.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rentocar.model.UserLog;

public interface UserLogRepository extends MongoRepository<UserLog, String>{

	public List<UserLog> findUserLogByUserId(String userId);
}
