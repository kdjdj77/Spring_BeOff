package com.lec.spring.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.repository.AuthorityRepository;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.hotel.AdminHotelRepository;
import com.lec.spring.repository.hotel.HotelRepository;

@Service
public class AdminHotelService {
	
	@Autowired
	private AdminHotelRepository adminHotelRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthorityRepository authorityRepository;
	@Autowired
	private RegionRepository regionRepository;
	@Autowired
	private HotelRepository hotelRepository;
	
	public int registerHotel(String username, String hotelname, String region, String content) {
		Hotel h = new Hotel();
		h.setUser(userRepository.findByUsername(username));
		h.setHotelname(hotelname);
		h.setRegion(regionRepository.findByRegion(region));
		h.setContent(content);
		hotelRepository.saveAndFlush(h);
		return 1;
	}
}