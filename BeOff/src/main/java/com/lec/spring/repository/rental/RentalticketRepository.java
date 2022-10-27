package com.lec.spring.repository.rental;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.rental.Rental;
import com.lec.spring.domain.rental.Rentalticket;

public interface RentalticketRepository extends JpaRepository<Rentalticket, Long> {
	List<Rentalticket> findByCar_Rental(Rental rental);
}
