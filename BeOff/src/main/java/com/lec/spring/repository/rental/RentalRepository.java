package com.lec.spring.repository.rental;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.rental.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long> {

}
