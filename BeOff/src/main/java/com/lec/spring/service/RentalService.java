package com.lec.spring.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

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
import com.lec.spring.domain.rental.Rentalticket;
import com.lec.spring.domain.rental.TicketDTO;
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
	
	
	// 자동차 리스트 
	public List<Car> getCarList(String sDate, String eDate, String rentalId, String sizeOption) {
		Long id = Long.parseLong(rentalId);
		Rental r = rentalRepository.findById(id).orElse(null);
		if (sizeOption.equals("all")) {
			return carRepository.findByRental(r).stream().filter(car -> car.enabled(sDate.replace("-", ""), eDate.replace("-", ""))).collect(Collectors.toList());
		} else if (sizeOption.equals("small")) {
			return carRepository.findByRentalAndCartype(r, "소형").stream().filter(car -> car.enabled(sDate.replace("-", ""), eDate.replace("-", ""))).collect(Collectors.toList());
		} else if (sizeOption.equals("middle")) {
			return carRepository.findByRentalAndCartype(r, "중형").stream().filter(car -> car.enabled(sDate.replace("-", ""), eDate.replace("-", ""))).collect(Collectors.toList());
		} else if (sizeOption.equals("large")) {
			return carRepository.findByRentalAndCartype(r, "대형").stream().filter(car -> car.enabled(sDate.replace("-", ""), eDate.replace("-", ""))).collect(Collectors.toList());
		} else {
			return carRepository.findByRentalAndCartype(r, "SUV").stream().filter(car -> car.enabled(sDate.replace("-", ""), eDate.replace("-", ""))).collect(Collectors.toList());
		}
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
				.filter(rental -> rental.getCars().stream()
						.anyMatch(car -> car.enabled(sDate, eDate))
				)
				.collect(Collectors.toList());
	}


	public void reservateCar(User userData, Long carId, Long sDate, Long eDate) {
		LongStream.range(sDate, eDate + 1).forEach(date -> {
			Rentalticket carTicket = new Rentalticket();
			carTicket.setUser(userData);
			carTicket.setCar(carRepository.findById(carId).get());
			carTicket.setDate(date);
			carTicket.setRegDate(LocalDateTime.now());
			rentalticketRepository.save(carTicket);
		});
	}
	

	public Map<Car, String> mapByUser(User user) {
		 return rentalticketRepository.findByUser(user).stream()
				.collect(Collectors.groupingBy(Rentalticket::getCar, 
						Collectors.mapping(ticket -> parseToDateForamt(ticket.getDate().toString()), 
								Collectors.joining(", "))));
	}
	
	public List<TicketDTO> getTickets(User user) {
		List<Rentalticket> allticket = rentalticketRepository.findByUserOrderByIdDesc(user);
		List<TicketDTO> tlist = new ArrayList<TicketDTO>();
		TicketDTO dto = new TicketDTO();
		
		for (Rentalticket t : allticket) {
			if (!dto.getRegDateTime().equals(t.getRegDateTime()) ||
					dto.getCar().getId() != t.getCar().getId()) {
				tlist.add(dto);
				dto = new TicketDTO();
				dto.setCar(t.getCar());
				dto.setPrice(t.getCar().getPrice());
				dto.addDate(t.getDate());
				dto.setRegDate(t.getRegDate());
			} else {
				dto.addDate(t.getDate());
				dto.setPrice(dto.getPrice() + t.getCar().getPrice());
			}
		}
		tlist.add(dto);
		
		return tlist;
	}
	
	private String parseToDateForamt(String yyyyMMdd) {
		return yyyyMMdd.substring(0, 4) + "-" + yyyyMMdd.substring(4, 6) + "-" + yyyyMMdd.subSequence(6, 8);
	}

	
	// 특정 업체 디테일
	
}
