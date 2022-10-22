package com.lec.spring.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.domain.hotel.Room;
import com.lec.spring.repository.AuthorityRepository;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.hotel.AdminHotelRepository;
import com.lec.spring.repository.hotel.HotelRepository;
import com.lec.spring.repository.hotel.RoomRepository;

@Service
public class AdminHotelService {
	
	@Autowired
	private AdminHotelRepository adminHotelRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthorityRepository authorityRepository;
	@Autowired
	private RegionRepository regionRepository;
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private RoomRepository roomRepository;
	
	// 호텔 등록
	@Transactional
	public int registerHotel(String username, String hotelname, String region, String content) {
		Hotel h = new Hotel();
		h.setUser(userRepository.findByUsername(username));
		h.setHotelname(hotelname);
		h.setRegion(regionRepository.findByRegion(region));
		h.setContent(content);
		hotelRepository.saveAndFlush(h);
		return 1;
	}
	
	// 룸 등록
	@Transactional
	public int registerRoom(String roomname, float price, Long bed) {
		Room r = new Room();

		r.setRoomname(roomname);
		r.setPrice(price);
		r.setBed(bed);
		roomRepository.saveAndFlush(r);
		return 1;
	}
	
	// 지역 리스트 찾기
	@Transactional
	public List<String> getRegionList(){
		List<Region> list = regionRepository.findAll();	
		List<String> sList = new ArrayList<String>();
		
		for(Region line : list) {
			sList.add(line.getRegion());
		}
		
		System.out.println(sList);
		
		return sList;
	}

	// 모든 호텔 리스트 조회
	public List<String> getHotelList() {
		List<Hotel> list = adminHotelRepository.findAll();
		List<String> hList = new ArrayList<String>();
		
		for(Hotel line : list) {
			hList.add(line.getHotelname());
		}
		
		return hList;
	}

	
}
