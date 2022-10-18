package com.lec.spring.repository.hotel;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.hotel.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}