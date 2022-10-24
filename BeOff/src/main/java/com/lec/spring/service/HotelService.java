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
		List<Hotel> h = null;
		List<Double> pList = new ArrayList<Double>();
		h = hotelRepository.findAll(Sort.by(Order.asc("id")));
		for(Hotel i : h) {
			pList.clear();
			System.out.println(i.getId());
			System.out.println(i.getUser());
			System.out.println(i.getHcomments());
			for(Room j : i.getRooms()) {
				System.out.println("누구 : " + j.getRoomname() + " " + "가격 : " + j.getPrice());
				pList.add(j.getPrice());
			}
			
			for(Double p : pList) {
				if(i.getPriceList() != null) {
					i.setPriceList(i.getPriceList() + " , " + Double.toString(p));
				}else {
					i.setPriceList(Double.toString(p));
				}
				System.out.println("가격 : "+i.getPriceList());
			}
		}
		return h;
	}


	public List<Room> getRoomList() {
		List<Room> RoomList = null;
		RoomList = roomRepository.findAll(Sort.by(Order.asc("id")));
		return RoomList;
	}
	

	public List<Hcomment> getHcommentList() {
		List<Hcomment> HcommentList = null;
		HcommentList = hcommentRepository.findAll(Sort.by(Order.asc("id")));
		return HcommentList;
	}
	
	// 호텔 id 에 해당하는 룸 들 get 
	
//	public List<Room> getPrice() {
//		Long id = null;
//		List<Room> roomPrice = null;
//		roomPrice = roomRepository.findById(id);
//		
//		return roomPrice;
//	}
	
	
//	public List<Hotel> getRoomPrice() {
//		List<Room> RoomPrice = new ArrayList<Room>();
//		List<Hotel> HotelList = new ArrayList<Hotel>();
//		RoomPrice = roomRepository.findById();
//		HotelList = hotelRepository.findAll();		
//		
//		
//		
//		for(Hotel h : HotelList) {
//			for(Room r : RoomPrice) {
//				HotelList.addAll(r.getRoomname());
//			}
//		}
//		HotelList.add((Hotel) RoomPrice);
//		
//		
//		
//		return HotelList;
//	}
	

	
	
	
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
