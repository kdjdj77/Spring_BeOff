package com.lec.spring.repository.air;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.air.Airname;
import com.lec.spring.domain.air.Airplane;
import com.lec.spring.domain.air.Airtime;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
	List<Airplane> findByDepartAndArriveAndTime(Region depart, Region arrive, Airtime time);
}
