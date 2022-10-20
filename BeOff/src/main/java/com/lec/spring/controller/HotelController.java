package com.lec.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/hotel")
public class HotelController {



	
	public HotelController() {
		System.out.println(getClass().getName() + "() 생성");
	}
	
}
