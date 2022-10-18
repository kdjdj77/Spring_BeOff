package com.lec.spring.repository.air;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.air.Airplane;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

}
