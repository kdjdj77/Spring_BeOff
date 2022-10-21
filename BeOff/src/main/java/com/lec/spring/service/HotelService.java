package com.lec.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.lec.spring.domain.Region;
import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.hotel.HcommentRepository;
import com.lec.spring.repository.hotel.HotelRepository;
import com.lec.spring.repository.hotel.RoomRepository;

@Service
public class HotelService {
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private HcommentRepository hcommentRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private RegionRepository regionRepository;


	public HotelService() {
		System.out.println(getClass().getName() + "() 생성");
	}

	// hotel 지역 목록
	public List<String> getRegionList() {
		List<String> RList = new ArrayList<String>();
		List<Region> regionList = regionRepository.findAll();
		for (Region r : regionList) {
			RList.add(r.getRegion());
		}
		return RList;
	}

	// 전체 숙소 목록
	public List<String> getHname() {
		List<String> Hname = new ArrayList<String>();
		List<Hotel> hotelList = hotelRepository.findAll();
//		List<String> RList = new ArrayList<String>();
//		List<Room> roomList = roomRepository.findByHotel();
		for (Hotel h : hotelList) {
			Hname.add(h.getHotelname());
		}
		return Hname;
	}
	
	public List<String> getHcontent(){
		List<String> Hcontent = new ArrayList<String>();
		List<Hotel> hotelList = hotelRepository.findAll();
		
		for(Hotel h : hotelList) {
			Hcontent.add(h.getContent());
			
		}
		return Hcontent;
		
	}

//	public Object getHotelList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
}
