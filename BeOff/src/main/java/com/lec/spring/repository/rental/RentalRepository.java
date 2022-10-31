package com.lec.spring.repository.rental;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.User;
import com.lec.spring.domain.rental.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long> {
	List<Rental> findAll();
	List<Rental> findByRegion(Region region);
	List<Rental> findByUser(User user);
	
}
