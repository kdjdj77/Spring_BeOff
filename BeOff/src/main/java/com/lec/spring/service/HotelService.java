package com.lec.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;


import com.lec.spring.domain.Region;
import com.lec.spring.domain.hotel.Hcomment;
import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.domain.hotel.Room;
import com.lec.spring.domain.qna.Qna;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.hotel.HcommentRepository;
import com.lec.spring.repository.hotel.HotelRepository;
import com.lec.spring.repository.hotel.RoomRepository;
import com.lec.spring.repository.hotel.RoomticketRepository;

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
	@Autowired
	private RoomticketRepository roomticketRepository;


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
//	public List<Hotel> getHotelList() {
//		List<String> HList = new ArrayList<String>();
//		List<Hotel> hotelList = hotelRepository.findAll();
//	}
	public List<Hotel> getHotelList() {
		List<Hotel> HotelList = null;
		
		HotelList = hotelRepository.findAll(Sort.by(Order.asc("id")));
		return HotelList;
	}

	public List<Hcomment> getHcommentList() {
		List<Hcomment> HcommentList = null;
		HcommentList = hcommentRepository.findAll(Sort.by(Order.asc("id")));
		return HcommentList;
	}

	public List<Room> getRoomList() {
		List<Room> RoomList = null;
		RoomList = roomRepository.findAll(Sort.by(Order.asc("id")));
		return RoomList;
	}

	public List<Hotel> getSearchHotels(String hotelregion, String checkinDate, String checkoutDate) {
		Region region = regionRepository.findByRegion(hotelregion);
		List<Hotel> list = hotelRepository.findByRegion(region);
		List<Hotel> dellist = new ArrayList<Hotel>();
		Long s = Long.parseLong(checkinDate);
		Long e = Long.parseLong(checkoutDate);
		int roomcnt;
		int ticketcnt;
		List<Long> dateList = new ArrayList<Long>() ; 
		for(Long i = s; i < e ; i++) {
			dateList.add(i);
		}
		for(Hotel h : list) {
			List<Room> rList = h.getRooms();
			roomcnt = rList.size();
			ticketcnt = 0;
			for(Room r : rList) {
				Loop2:
				for(Long d : dateList) {
					if(roomticketRepository.findByDateAndRoom(d,r).size() != 0) {
							ticketcnt ++;
						break Loop2;
					}					
				}
			}
			if(roomcnt == ticketcnt) {
				dellist.add(h);
				
			}
		}
		
		for(Hotel h : dellist) {
			list.remove(h);
			
		}
		return list;
	}
	
	
	
}
