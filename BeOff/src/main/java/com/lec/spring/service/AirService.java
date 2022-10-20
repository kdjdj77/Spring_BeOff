package com.lec.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.air.Airplane;
import com.lec.spring.domain.air.Airtime;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.air.AirplaneRepository;
import com.lec.spring.repository.air.AirtimeRepository;

@Service	
public class AirService {

	@Autowired
	ServletContext context;   // ServletContext 도 주입받을수 있다.
	
	@Autowired
	private AirplaneRepository airplaneRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AirtimeRepository airtimeRepository;
	@Autowired
	private RegionRepository regionRepository;

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
	
	public List<String> getAirTimeList() {
		List<String> rTimeList = new ArrayList<String>();
		List<Airtime> airTimeList = airtimeRepository.findAll();
		for (Airtime i : airTimeList) {
			rTimeList.add(i.getTime());
		}
		return rTimeList;		
	}

} // end Service
