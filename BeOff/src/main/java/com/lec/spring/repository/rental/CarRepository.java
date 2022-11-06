package com.lec.spring.repository.rental;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.rental.Car;
import com.lec.spring.domain.rental.Rental;

public interface CarRepository extends JpaRepository<Car, Long> {
	Car findBycarname (String carname);
	List<Car> findByRentalAndCartype(Rental r, String a);
	List<Car> findByRental(Rental r);
}
