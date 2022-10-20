package com.lec.spring.service.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.spring.repository.hotel.HcommentRepository;
import com.lec.spring.repository.hotel.HotelRepository;

@Service
public class HotelService {
	private HotelRepository hotelRepository;
	private HcommentRepository hcommentRepository;

	@Autowired
	public void setHotelRepository(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@Autowired
	public void setHcommentRepository(HcommentRepository hcommentRepository) {
		this.hcommentRepository = hcommentRepository;
	}

	public HotelService() {
		System.out.println(getClass().getName() + "() 생성");
	}

}
