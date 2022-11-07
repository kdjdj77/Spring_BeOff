package com.lec.spring.repository.hotel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.lec.spring.domain.User;
import com.lec.spring.domain.Region;
import com.lec.spring.domain.hotel.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

	List<Hotel> findAll();

	List<Hotel> findByUser(User u);
	List<Hotel> findByRegion(Region region);

	List<Hotel> findByUserOrderByIdDesc(User u);


}