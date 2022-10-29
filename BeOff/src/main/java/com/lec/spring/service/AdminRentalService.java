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
			for(Float ad : adList) {
				if(r.getPriceList() != null) {
					r.setPriceList(r.getPriceList() + " , " + Float.toString(ad));
				} else {
					r.setPriceList(Float.toString(ad));
				}
			}
			System.out.println(r.getPriceList());
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
}
