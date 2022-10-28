package com.lec.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.User;
import com.lec.spring.domain.rental.Car;
import com.lec.spring.domain.rental.Rental;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.rental.CarRepository;
import com.lec.spring.repository.rental.CarfileRepository;
import com.lec.spring.repository.rental.RentalRepository;
import com.lec.spring.repository.rental.RentalticketRepository;
import com.lec.spring.util.U;

@Service
@Transactional
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
	@Autowired
	private RentalticketRepository rentalticketRepository;
	
	public RentalService() {
		System.out.println(getClass().getName() + "()생성");
	}	
	
	public List<String> getRegionList(){
		return regionRepository.findAll().stream()
				.map(Region::getRegion)
				.collect(Collectors.toList());
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
	    return rentalRepository.findAll(Sort.by(Order.asc("id")));
	}

	public Rental getRentalById(String rentalId) {
		Long id = Long.parseLong(rentalId);
		return rentalRepository.findById(id).get();
	}

	public User getUserData() {
		
		return U.getLoggedUser();
	}

	public Car getCarById(String carId) {
		Long id = Long.parseLong(carId);
		return carRepository.findById(id).get();
	}

	public List<Rental> getRentalRList(String rRegion, String sDate, String eDate) {
		Region region = regionRepository.findByRegion(rRegion);
		return rentalRepository.findByRegion(region).stream()
				.filter(rental -> {
					return rental.getCars().stream()
						.anyMatch(car -> car.enabled(sDate, eDate));
				})
				.collect(Collectors.toList());
	}
	
	// 특정 업체 디테일
	
}
