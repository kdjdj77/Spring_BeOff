package com.lec.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.spring.domain.Region;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.air.AirplaneRepository;

@Service	
public class AirService {

	@Autowired
	ServletContext context;   // ServletContext 도 주입받을수 있다.
	
	private AirplaneRepository airplaneRepository;
	private UserRepository userRepository;
	private RegionRepository regionRepository;

	@Autowired
	public void setWriteRepository(AirplaneRepository airplaneRepository) {
		this.airplaneRepository = airplaneRepository;}
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;}
	@Autowired
	public void setRegionRepository(RegionRepository regionRepository) {
		this.regionRepository = regionRepository;}

	public AirService() {
		System.out.println(getClass().getName() + "() 생성");
	}	
	
	@Transactional
	public List<String> getRegionList() {
		List<String> rNameList = new ArrayList<String>();
		List<Region> regionList = regionRepository.findAll();
		for (Region i : regionList) {
			rNameList.add(i.getRegion());
		}
		return rNameList;		
	}
	

} // end Service
