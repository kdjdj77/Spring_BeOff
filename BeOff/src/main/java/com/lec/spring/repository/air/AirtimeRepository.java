package com.lec.spring.repository.air;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.air.Airtime;

public interface AirtimeRepository extends JpaRepository<Airtime, Long> {
	List<Airtime> findAll();
	Airtime findByTime(String time);
}
