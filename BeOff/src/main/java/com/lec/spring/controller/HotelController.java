package com.lec.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.spring.service.hotel.HotelService;



@Controller
@RequestMapping("/hotel")
public class HotelController {


	private HotelService hotelService;

	@Autowired
	public void setHotelService(HotelService hotelSerivce) {
		this.hotelService = hotelSerivce;
	}
	public HotelController() {
		System.out.println(getClass().getName() + "() 생성");
	}
	
	// /hotel/basic
	@GetMapping("/basic")
	public String basic(Model model) {
		model.addAttribute("regionList", hotelService.getReionList());
		return "/hotel/basic";	
		
	}
	// /hotel/list
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("roomInfo", hotelService.getRoomInfo());
		return "/hotel/list";	
		
	}
	// /hotel/room/detail
	
}
