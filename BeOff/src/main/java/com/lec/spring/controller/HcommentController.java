package com.lec.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.spring.service.HotelService;

@RestController
@RequestMapping("/comment")
public class HcommentController {
	@Autowired
	private HotelService hotelService;
	
	public HcommentController() {
		System.out.println(getClass().getName() + "()생성");
	}
	
}
