package com.lec.spring.repository.rental;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.rental.Carfile;

public interface CarfileRepository extends JpaRepository<Carfile, Long> {
	// 특정 car의 이미지
	List<Carfile> findByCar(Long carId);
}
