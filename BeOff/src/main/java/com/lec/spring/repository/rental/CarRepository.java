package com.lec.spring.repository.rental;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.rental.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
	Car findBycarname (String carname);
}
