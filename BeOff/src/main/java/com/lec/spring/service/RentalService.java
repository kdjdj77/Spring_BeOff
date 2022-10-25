package com.lec.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.rental.Car;
import com.lec.spring.domain.rental.Rental;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.rental.CarRepository;
import com.lec.spring.repository.rental.CarfileRepository;
import com.lec.spring.repository.rental.RentalRepository;

@Service
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
	
	public List<String> getRegionList(){
		List<String> rList = new ArrayList<>();
		List<Region> regionList = regionRepository.findAll();
		for(Region r : regionList) {
			rList.add(r.getRegion());
		}
		return rList;
	}
	
	/*
	 * public List<String> getCarNameList() { List<String> cList = new
	 * ArrayList<>(); List<Car> carNameList = carRepository.findAll(); for(Car c :
	 * carNameList) { cList.add(c.getCarname()); } return cList;
	 * 
	 * }
	 */
	
	public List<Rental> getRentalList() {
	      List<Rental> rentalList = null;
	      
	      rentalList = rentalRepository.findAll(Sort.by(Order.asc("id")));
	      return rentalList;
	   }
	

}
