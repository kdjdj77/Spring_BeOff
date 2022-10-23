package com.lec.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.rental.CarRepository;
import com.lec.spring.repository.rental.CarfileRepository;
import com.lec.spring.repository.rental.RentalRepository;

public class RentalService {
	
	private RentalRepository rentalRepository;
	private CarfileRepository carfileRepository;
	private CarRepository carRepository;
	private UserRepository userRepository;
	private RegionRepository regionRepository;
	
	
	
	@Autowired
	public void setRentalRepository(RentalRepository rentalRepository) {
		this.rentalRepository = rentalRepository;
	}
	
	@Autowired
	public void setCarfileRepository(CarfileRepository carfileRepository) {
		this.carfileRepository =  carfileRepository;
	}
	
	@Autowired
	public void setCarRepository(CarRepository carRepository) {
		this.carRepository =  carRepository;
	}
	
	@Autowired
	   public void setUserRepository(UserRepository userRepository) {
	      this.userRepository = userRepository;}
	
	@Autowired
	   public void setRegionRepository(RegionRepository regionRepository) {
	      this.regionRepository = regionRepository;}
	
	public RentalService() {
		System.out.println(getClass().getName() + "()생성");
	}

}
