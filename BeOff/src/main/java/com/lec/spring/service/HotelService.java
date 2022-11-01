package com.lec.spring.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.User;
import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.domain.hotel.Room;
import com.lec.spring.domain.hotel.Roomticket;
import com.lec.spring.domain.hotel.TicketDTO;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.hotel.HcommentRepository;
import com.lec.spring.repository.hotel.HotelRepository;
import com.lec.spring.repository.hotel.RoomRepository;
import com.lec.spring.repository.hotel.RoomfileRepository;
import com.lec.spring.repository.hotel.RoomticketRepository;
import com.lec.spring.util.U;

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
	@Autowired
	private RoomfileRepository roomfileRepository;

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
		
	
	//호텔 리스트 + 룸 가격
	public List<Hotel> getHotelList() {
		List<Double> pList = new ArrayList<Double>();
		List<Hotel> h = null;

	
		h = hotelRepository.findAll(Sort.by(Order.asc("id")));
		
		for(Hotel i : h) {
			pList.clear();

			for(Room j : i.getRooms()) {
	
				pList.add(j.getPrice());
			}
			for(Double p : pList) {
				if(i.getPriceList() != null) {
					i.setPriceList(i.getPriceList() + Double.toString(p));
				}else {
					i.setPriceList(Double.toString(p));
				}
				Double a = Collections.max(pList);
				Double b = Collections.min(pList);
				i.setPriceList(Double.toString(b)+"원  ~ " + Double.toString(a)+"원");
			}
		}
		return h;
	}
	
	// 숙소 검색
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



	// 숙소 id 값으로 정보 (hotel, room, comment)
	// detail 
	public Hotel getHotelById(String id) {
		Long lId = Long.parseLong(id);
		Hotel h = hotelRepository.findById(lId).get();

		
		return h;
	}

	public Room getRoomById(String id) {
		Long lId = Long.parseLong(id);
		Room r = roomRepository.findById(lId).get();
		
		
		return r;
	}
	// 특정 호텔(id)의 댓글 목록들
//	public HqryCommentList getCommentList(Long id) {
//		
//		HqryCommentList list = new HqryCommentList();
//		List<Hcomment> comments = hcommentRepository.findByHotel(id, Sort.by(Order.desc("id")));
//		System.out.println("--------------------------------");
//		System.out.println(comments);
//		System.out.println("--------------------------------");
//		list.setCount(comments.size());
//		list.setList(comments);		
//		list.setStatus("OK");
//		return list;
//	}
//	
//	// 특정 글(hotelId)에 특정 사용자(UserId)가 댓글 작성
//	public HqryResult write(Hotel hotel, Long userId, String content, Long star) {
//		User user = userRepository.findById(userId).orElse(null);
//		
//		Hcomment comment = Hcomment.builder()
//				.user(user)
//				.content(content)
//				.star(star)
//				.hotel(hotel)
//				.build()
//				;
//		hcommentRepository.save(comment); // INSERT
//		HqryResult result = HqryResult.builder()
//				.count(1)
//				.status("OK")
//				.build()
//				;
//		return result;
//	}
//	
//	// 특정 댓글(id) 삭제
//	public HqryResult delete(Long id) {
//		Hcomment comment = hcommentRepository.findById(id).orElse(null);
//		
//		int count = 0;
//		String status = "FAIL";
//		if (comment != null) {
//			hcommentRepository.delete(comment);
//			count = 1;
//			status = "OK";
//		}
//		HqryResult result = HqryResult.builder()
//				.count(count)
//				.status(status)
//				.build()
//				;
//		return result;
//	}
	
	public Room reserve(String id) {
		Room r = roomRepository.findById(Long.parseLong(id)).orElse(null);
		return r;	
	}

	public User getUserData() {
		
		return U.getLoggedUser();
	}

	public void registerRoomticket(Room r, String checkin, String checkout) {
		String s = checkin.replaceAll("-", "");
		String e = checkout.replaceAll("-", "");
		
		Long sDate = Long.parseLong(s);
		Long eDate = Long.parseLong(e);
		
		for(Long i = sDate; i < eDate; i++) {
			Roomticket rt = new Roomticket();
			rt.setUser(U.getLoggedUser());
			rt.setRoom(r);
			rt.setDate(i);
			roomticketRepository.saveAndFlush(rt);
		}
	}
	
	public List<TicketDTO> getRoomTickets() {
		Roomticket rt = new Roomticket();
		List<Roomticket> list = roomticketRepository.findByUser(U.getLoggedUser());
		List<TicketDTO> tickets = new ArrayList<TicketDTO>();
		TicketDTO tk = new TicketDTO();
		int cnt=0;
		for(Roomticket rtk : list) {
			if(!rt.getRegDateTime().equals(rtk.getRegDateTime())) {
				tickets.add(tk);
				rt = rtk;
				tk.setRoom(rt.getRoom());
				tk.addDate(rt.getDate());
				tk.setPrice(rt.getRoom().getPrice());
				tk.setRegDate(rt.getRegDate());
			}else {
				tk.addDate(rtk.getDate());
				tk.setPrice(tk.getPrice()+rtk.getRoom().getPrice());
			}
		}
		
		return tickets;
//		return roomticketRepository.findByUser(U.getLoggedUser());
	} 
	
}
