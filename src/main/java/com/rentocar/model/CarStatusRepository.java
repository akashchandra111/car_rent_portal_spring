package com.rentocar.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarStatusRepository extends JpaRepository<CarStatus, String>{
	@Query(value="select * from car_status where car_id_car_id=?1", nativeQuery=true)
	public List<CarStatus> findByCarId(String carId);
	
//	@Query(value="update car_status set car_no=?1, status=?4, car_id_car_id=?2, user_id_user_id=?3 where car_no=?1", nativeQuery=true)
//	public CarStatus update(String carNo, String carId, String userId, String status);
}
