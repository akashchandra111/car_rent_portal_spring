package com.rentocar.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarStatusRepository extends JpaRepository<CarStatus, String>{
	@Query(value="select * from car_status where car_id_car_id=?1", nativeQuery=true)
	public List<CarStatus> findByCarId(String carId);

	@Query(value="select car_status.car_no, car_status.status, car_status.car_id_car_id, car_status.user_id_user_id from car_status inner join car on car.car_id=car_status.car_id_car_id and car_status.status='booked' and car.car_type=?1", nativeQuery=true)
	public List<CarStatus> getTotalBookedOfCarType(String carType);

	@Query(value="select car_status.car_no, car_status.status, car_status.car_id_car_id, car_status.user_id_user_id from car_status inner join car on car.car_id=car_status.car_id_car_id and car_status.status='available' and car.car_type=?1", nativeQuery=true)
	public List<CarStatus> getTotalAvailableOfCarType(String carType);
	
//	@Query(value="update car_status set car_no=?1, status=?4, car_id_car_id=?2, user_id_user_id=?3 where car_no=?1", nativeQuery=true)
//	public CarStatus update(String carNo, String carId, String userId, String status);
}
