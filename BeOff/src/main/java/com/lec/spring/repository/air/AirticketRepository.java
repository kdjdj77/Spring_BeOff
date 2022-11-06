package com.lec.spring.repository.air;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.User;
import com.lec.spring.domain.air.Airplane;
import com.lec.spring.domain.air.Airticket;

public interface AirticketRepository extends JpaRepository<Airticket, Long> {
	List<Airticket> findByAirplaneAndDate(Airplane airplane, Long date);
	List<Airticket> findBySeatAndDate(String seat, Long date);
	List<Airticket> findByUserOrderByIdDesc(User user);
}
