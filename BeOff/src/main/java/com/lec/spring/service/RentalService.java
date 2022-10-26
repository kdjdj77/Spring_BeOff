package com.lec.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.User;
import com.lec.spring.domain.rental.Car;
import com.lec.spring.domain.rental.Rental;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.rental.CarRepository;
import com.lec.spring.repository.rental.CarfileRepository;
import com.lec.spring.repository.rental.RentalRepository;
import com.lec.spring.util.U;

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
	
	// 업체 리스트 
	public List<Rental> getRentalList() {
	    List<Rental> rentalList = null;
	      
	    rentalList = rentalRepository.findAll(Sort.by(Order.asc("id")));
	    return rentalList;
	}

	public Rental getRentalById(String rentalId) {
		Long id = Long.parseLong(rentalId);
		Rental r = rentalRepository.findById(id).get();
		
		return r;
	}

	public User getUserData() {
		
		return U.getLoggedUser();
	}

	public Car getCarById(String carId) {
		Long id = Long.parseLong(carId);
		Car c = carRepository.findById(id).get();
		
		return c;
		
	}

	public List<Rental> getRentalRList(String rRegion, String sDate, String eDate) {
		Region region = regionRepository.findByRegion(rRegion);
		List<Rental> list = rentalRepository.findByRegion(region);
		
		return list;
	}



	
	
	// 특정 업체 디테일
	
	

}
