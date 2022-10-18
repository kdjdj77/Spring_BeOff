package com.lec.spring.repository.air;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.air.Airname;

public interface AirnameRepository extends JpaRepository<Airname, Long> {

}
