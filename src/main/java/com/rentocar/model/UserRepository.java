// UserRepository [Author: Akash Chandra]
package com.rentocar.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	@Query(value="select * from user where user_name=?1 or email=?1 or mobile_num=?1 and password=?2", nativeQuery=true)
	public Optional<User> findUser(String id, String password);
}
