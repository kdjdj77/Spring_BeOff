package com.lec.spring.service.hotel;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.User;
import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.domain.hotel.Room;
import com.lec.spring.domain.qna.Qna;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.hotel.HcommentRepository;
import com.lec.spring.repository.hotel.HotelRepository;
import com.lec.spring.repository.hotel.RoomRepository;
import com.lec.spring.util.U;

@Service
public class HotelService {
	private HotelRepository hotelRepository;
	private UserRepository userRepository;
	private HcommentRepository hcommentRepository;
	private RoomRepository roomRepository;
	private RegionRepository regionRepository;

	@Autowired
	public void setHotelRepository(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@Autowired
	public void setHcommentRepository(HcommentRepository hcommentRepository) {
		this.hcommentRepository = hcommentRepository;
	}
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Autowired
	public void setRoomRepository(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	@Autowired
	public void setRegionRepository(RegionRepository regionRepository) {
		this.regionRepository = regionRepository;
	}

	public HotelService() {
		System.out.println(getClass().getName() + "() 생성");
	}

	// hotel 지역 목록
	public List<String> getReionList() {
		List<String> RList = new ArrayList<String>();
		List<Region> regionList = regionRepository.findAll();
		for(Region r : regionList) {
			RList.add(r.getRegion());
		}		
		return RList;
	}

	public List<String> getRoomInfo() {
		List<String> RInfo = new ArrayList<String>();
		List<Room> roomInfo = roomRepository.findAll();
//		List<Hotel> hotelInfo = hotelRepository.findAll();
		for(Room room : roomInfo) {
			RInfo.add(room.getRoomname());
		}
//		for(Hotel hotel : hotelInfo) {
//			RInfo.add(hotel.getAvgstar());
//		}
		return RInfo;
	}
	// 전체 목록
	public List<Room> RoomList() {
		List<Room> RoomList = null;
		
		RoomList = roomRepository.findAll(Sort.by(Order.desc("id")));
		
		return RoomList;
	}

	

	







}
