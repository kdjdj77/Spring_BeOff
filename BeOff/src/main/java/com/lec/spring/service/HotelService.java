package com.lec.spring.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.User;
import com.lec.spring.domain.hotel.Hcomment;
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
import com.lec.spring.util.C;
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
	
	public List<Hotel> list(Integer page, Model model){
		if(page == null) page = 1;
		if(page < 1) page = 1;
		
		HttpSession session = U.getSession();
		Integer writePages = (Integer)session.getAttribute("writePages");
		if(writePages == null) writePages = C.WRITE_PAGES;
		Integer pageRows = (Integer)session.getAttribute("pageRows");
		if(pageRows == null) pageRows = C.PAGE_ROWS;   // session 에 없으면 기본값으로
		session.setAttribute("page", page);
		
		Page<Hotel> pageWrites = hotelRepository.findAll(PageRequest.of(page - 1, pageRows, Sort.by(Order.desc("id"))));	

		long cnt = pageWrites.getTotalElements();   // 글 목록 전체의 개수
		int totalPage = pageWrites.getTotalPages(); //총 몇 '페이지' 분량인가?
		if(page > totalPage) page = totalPage;   // 페이지 보정

		// [페이징] 에 표시할 '시작페이지' 와 '마지막페이지' 계산
		int startPage = ((int)((page - 1) / writePages) * writePages) + 1;
		int endPage = startPage + writePages - 1;
		if (endPage >= totalPage) endPage = totalPage;
		
		model.addAttribute("cnt", cnt);  // 전체 글 개수
		model.addAttribute("page", page); // 현재 페이지
		model.addAttribute("totalPage", totalPage);  // 총 페이지 수
		model.addAttribute("pageRows", pageRows);  // 한 페이지 에 표시할 글 개수
		
		// [페이징]
		model.addAttribute("url", U.getRequest().getRequestURI());  // 목록 url
		model.addAttribute("writePages", writePages); // 페이징 에 표시할 숫자 개수
		model.addAttribute("startPage", startPage);  // 페이징 에 표시할 시작 페이지
		model.addAttribute("endPage", endPage);   // 페이징 에 표시할 마지막 페이지

		List<Double> pList = new ArrayList<Double>();
		List<Hotel> list = pageWrites.getContent();	
		for(Hotel i : list) {
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
		model.addAttribute("list", list);
		
		return list;
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
		for(Roomticket rtk : list) {
			if(!rt.getRegDateTime().equals(rtk.getRegDateTime()) ||
					rt.getRoom().getId() != rtk.getRoom().getId()) {
				tickets.add(tk);
				rt = rtk;
				tk = new TicketDTO(); 
				tk.addDate(rt.getDate());
				tk.setRoom(rt.getRoom());
				tk.setPrice(rt.getRoom().getPrice());
				tk.setRegDate(rt.getRegDate());
			}else {
				tk.addDate(rtk.getDate());
				tk.setPrice(tk.getPrice() + rtk.getRoom().getPrice());
			}
		}
		tickets.add(tk);
		return tickets;
	} 

	
}
