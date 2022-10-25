package com.lec.spring.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.User;
import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.domain.hotel.Room;
import com.lec.spring.repository.AuthorityRepository;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.hotel.AdminHotelRepository;
import com.lec.spring.repository.hotel.HotelRepository;
import com.lec.spring.repository.hotel.RoomRepository;
import com.lec.spring.util.U;

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
	
	// 룸 등록 - 선택한 호텔에 대한 룸 등록.
	public int registerRoom(String id, String roomname, Double price, Long bed) {
		Room r = new Room();
		
		Long hotelId = Long.parseLong(id);
		
		Hotel h = adminHotelRepository.findById(hotelId).get();
		r.setHotel(h);
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

	// 로그인 한 관리자(adminhotel) "본인"이 등록한 모든 호텔 리스트 조회
	@Transactional
	public List<Hotel> getHotelList() {
		
		// 로그인한 유저정보
		User u = U.getLoggedUser();
		
		List<Double> pList = new ArrayList<Double>();
		
		List<Hotel> h = hotelRepository.findByUser(u);
		for(Hotel i : h) {
			pList.clear();
			for(Room j : i.getRooms()) {
				pList.add(j.getPrice());			
			}
			for(Double p : pList) {
				if(i.getPriceList() != null) {
					i.setPriceList(i.getPriceList()+" , "+Double.toString(p));					
				}else {
					i.setPriceList(Double.toString(p));
				}
			}
			System.out.println(i.getPriceList());
		}
		
		return h;
	}
	
	// 룸 리스트 id역순으로 가져오기
	@Transactional
	public List<Room> getRoomList() {
		List<Room> RoomList = null;
		RoomList = roomRepository.findAll(Sort.by(Order.asc("id")));
		return RoomList;
	}

	// 호텔의 id 값을 받아옴
	@Transactional
	public Hotel getHotelById(String id) {
		Long lId = Long.parseLong(id);
		Hotel h = hotelRepository.findById(lId).get();
		return h;
	}

	// 호텔 업데이트
	@Transactional
	public int updateHotel(String id, String hotelname, String region, String content) {

		int result = 0;
		
		Long lId = Long.parseLong(id);
		
		Hotel h = hotelRepository.findById(lId).get();
		Region r = regionRepository.findByRegion(region);
		
		h.setHotelname(hotelname);
		h.setRegion(r);
		h.setContent(content);
		h.setRooms(getRoomList());
		hotelRepository.save(h);
		
		result = 1;
		
		return result;
	}
	
	// 방 업데이트
	@Transactional
	public int updateRoom(String id, String roomname, Double price, Long bed) {

		int result = 0;
		
		Long lId = Long.parseLong(id);
		Room r = roomRepository.findById(lId).get();

		r.setRoomname(roomname);
		r.setPrice(price);
		r.setBed(bed);
		
		roomRepository.save(r);
		
		result = 1;
		
		return result;
	}

	// 호텔 삭제
	@Transactional
	public int deleteHotel(String id) {
		int result = 0;
		
		Long lId = Long.parseLong(id);
		
		Hotel h = hotelRepository.findById(lId).get();
		hotelRepository.delete(h);
		result = 1;
		
		return result;
	}
	
	// 룸 삭제
	@Transactional
	public int deleteRoom(String id) {
		int result = 0;
		
		Long lId = Long.parseLong(id);
		
		Room r = roomRepository.findById(lId).get();
		roomRepository.delete(r);
		System.out.println("서비스에서 id "+id);
		result = 1;
		
		return result;
	}
}
