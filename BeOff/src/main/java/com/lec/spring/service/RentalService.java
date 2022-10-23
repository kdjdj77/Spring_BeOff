package com.lec.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lec.spring.domain.Region;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.rental.CarRepository;
import com.lec.spring.repository.rental.CarfileRepository;
import com.lec.spring.repository.rental.RentalRepository;

public class RentalService {
	
	@Autowired
	private RentalRepository rentalRepository;
	@Autowired
	private CarfileRepository carfileRepository;
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RegionRepository regionRepository;
	
	public RentalService() {
		System.out.println(getClass().getName() + "()생성");
	}	
	
//	public List<String> getRegionList(){
//		List<String> rList = new ArrayList<>();
//		List<Region> regionList = regionRepository.findAll();
//		for(Region r : regionList) {
//			rList.add(r.getRegion());
//		}
//		return rList;
//	}

}
