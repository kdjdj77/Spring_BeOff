package com.lec.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.spring.domain.Region;
import com.lec.spring.repository.AuthorityRepository;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.rental.AdminRentalRepository;
import com.lec.spring.repository.rental.CarRepository;

@Service
public class AdminRentalService {

	@Autowired
	private AdminRentalRepository adminRentalRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private RegionRepository regionRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	// 지역 업체 리스트
	@Transactional
	public List<String> getRegionList() {
		List<Region> list = regionRepository.findAll();
		List<String> sList = new ArrayList<>();
		
		for(Region line : list) {
			sList.add(line.getRegion());
		}
		
		System.out.println(sList);
		
		return sList;
	}
}
