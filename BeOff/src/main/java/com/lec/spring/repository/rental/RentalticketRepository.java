package com.lec.spring.repository.rental;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.rental.Rentalticket;

public interface RentalticketRepository extends JpaRepository<Rentalticket, Long> {

}
