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
	
	// /hotel/list
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("regionList", hotelService.getRegionList());
		model.addAttribute("hotelname", hotelService.getHname());		
		model.addAttribute("hotelcontent", hotelService.getHcontent());		
//		model.addAttribute("hotelList", hotelService.getHotelList());
		return "/hotel/list";	
		
	}

	
}
