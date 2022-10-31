package com.lec.spring.repository.hotel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.hotel.Hotelfile;
import com.lec.spring.domain.hotel.Roomfile;

public interface HotelfileRepository extends JpaRepository<Hotelfile, Long> {

	List<Hotelfile> findByHotel(Long hotelId);
}
