package com.lec.spring.repository.air;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.air.Airtime;

public interface AirtimeRepository extends JpaRepository<Airtime, Long> {

}
