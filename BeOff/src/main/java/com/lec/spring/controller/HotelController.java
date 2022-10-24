package com.lec.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.service.HotelService;



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
//		model.addAttribute("hotelcontent", hotelService.getHcontent());		
		model.addAttribute("hotelList", hotelService.getHotelList());
		model.addAttribute("roomList", hotelService.getRoomList());
		return "/hotel/list";	
		
	}
	
	
	
	@PostMapping("/list")
	public String searchList(String hotelregion,String inn,String out, Model model) {
		String in1 = inn.replaceAll("-","");
		String out1 = out.replaceAll("-","");
		List<Hotel> list = hotelService.getSearchHotels(hotelregion,in1,out1);
		model.addAttribute("hotelList",list);
		model.addAttribute("roomList", hotelService.getRoomList());
		model.addAttribute("regionList", hotelService.getRegionList());
			
		return "/hotel/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// /hotel/list
	@GetMapping("/detail")
	public String detail(Model model) {
		model.addAttribute("regionList", hotelService.getRegionList());
//		model.addAttribute("hotelname", hotelService.getHname());		
//		model.addAttribute("hotelcontent", hotelService.getHcontent());		
		model.addAttribute("hotelList", hotelService.getHotelList());
		model.addAttribute("hcommentList", hotelService.getHcommentList());
		model.addAttribute("roomList", hotelService.getRoomList());
		return "/hotel/detail";	
		
	}

	
}
