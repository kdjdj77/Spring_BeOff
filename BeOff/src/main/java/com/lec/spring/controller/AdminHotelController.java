package com.lec.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.service.AdminHotelService;

@Controller
@RequestMapping("/hotel/admin")
public class AdminHotelController {

	@Autowired
	private AdminHotelService adminHotelService;

	public AdminHotelController() {
		System.out.println(getClass().getName() + "() 생성");
	}	

	// hotel/admin/list
	@GetMapping("/list")
	public String getHotelList(Model model) {
		
		List<Hotel> list = adminHotelService.getHotelList();
		model.addAttribute("hotelList", list);
		System.out.println(list);
		
		return "/hotel/admin/list";
	}
	
	// hotel/admin/write : 호텔, 룸 등록 
	@GetMapping("/write")
	public String RoomWrite(Model model) {
		List<String> list = adminHotelService.getRegionList();
		model.addAttribute("regionList", list);
		return "/hotel/admin/write";
	}
	
	// hotel/admin/HotelWriteOk : 호텔 등록 완료
	@PostMapping("/HotelWriteOk")
	public String writeOk(String username, String hotelname, String region, String content, Model model) {
		int result = 0;
		result = adminHotelService.registerHotel(username, hotelname, region, content);
		model.addAttribute("result", result);
		return "/hotel/admin/HotelWriteOk";
	}
	
	// hotel/admin/RoomWriteOk : 룸 등록 완료
	@PostMapping("/RoomWriteOk")
	public String writeOk(String roomname, float price, Long bed, Model model) {
		int result = 0;
		result = adminHotelService.registerRoom(roomname, price, bed);
		model.addAttribute("result", result);
		return "/hotel/admin/RoomWriteOk";
	}
	
	// hotel/admin/update
	@GetMapping("/update")
	public void update() {
		
	}
	

	
	// hotel/admin/delete

}
