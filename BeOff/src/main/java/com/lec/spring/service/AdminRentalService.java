package com.lec.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.User;
import com.lec.spring.domain.rental.Car;
import com.lec.spring.domain.rental.Rental;
import com.lec.spring.repository.AuthorityRepository;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.rental.AdminRentalRepository;
import com.lec.spring.repository.rental.CarRepository;
import com.lec.spring.repository.rental.RentalRepository;
import com.lec.spring.util.U;

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
	private RentalRepository rentalRepository;
	
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

	@Transactional
	public List<Rental> getRentalList() {
		User u = U.getLoggedUser();
		
		List<Float> adList = new ArrayList<>();
		
		List<Rental> rental = rentalRepository.findByUser(u);
		for(Rental r : rental) {
			adList.clear();
			for(Car c : r.getCars()) {
				adList.add(c.getPrice());
			}
		}
		return rental;
	}

	@Transactional
	public List<Car> getCarList() {
		List<Car> carList = null;
		carList = carRepository.findAll(Sort.by(Order.asc("id")));
		return carList;
	}

	@Transactional
	public Rental getRentalById(String id) {
		Long rId = Long.parseLong(id);
		Rental r = rentalRepository.findById(rId).get();
		return r;
	}

	public int registerRental(String rentalname, String content) {
		Rental r = new Rental();
		r.setRentalname(rentalname);
		r.setContent(content);
		rentalRepository.saveAndFlush(r);
		return 1;
	}

	public int updateRental(String id, String rentalname, String content) {
		int result = 0;
		
		Long rId = Long.parseLong(id);
		
		Rental r = rentalRepository.findById(rId).get();
		
		r.setRentalname(rentalname);
		r.setContent(content);
		rentalRepository.save(r);
		
		result = 1;
		
		return result;
	}
}
