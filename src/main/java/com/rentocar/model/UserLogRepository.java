// UserLogRepository [Author: Akash Chandra]
package com.rentocar.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLogRepository extends JpaRepository<UserLog, String>{
	@Query(value="SELECT * FROM user_log WHERE user_id_user_id=?1 ORDER BY start_time DESC", nativeQuery=true)
	public List<UserLog> findByUserId(String userId);
}
