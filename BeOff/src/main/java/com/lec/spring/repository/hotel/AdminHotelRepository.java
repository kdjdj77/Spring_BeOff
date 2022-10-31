package com.lec.spring.repository.hotel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.domain.hotel.Room;

public interface AdminHotelRepository extends JpaRepository<Hotel, Long> {
	
}
