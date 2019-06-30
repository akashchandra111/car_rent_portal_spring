// UserLogRepository [Author: Akash Chandra]
package com.rentocar.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLogRepository extends JpaRepository<UserLog, String>{
	public List<UserLog> findByUserId(String userId);
}
