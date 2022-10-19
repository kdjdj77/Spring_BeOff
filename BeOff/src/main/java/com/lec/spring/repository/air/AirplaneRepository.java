package com.lec.spring.repository.air;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.air.Airname;
import com.lec.spring.domain.air.Airplane;
import com.lec.spring.domain.air.Airtime;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
	Airplane findByDepartAndArriveAndTimeAndName(
			Region depart, Region arrive, Airtime time, Airname name);
}
