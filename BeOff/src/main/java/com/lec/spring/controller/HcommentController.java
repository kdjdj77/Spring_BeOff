package com.lec.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.spring.service.hotel.HcommentService;

@RestController
@RequestMapping("/comment")
public class HcommentController {

	private HcommentService hcommentSerivce;
	
	public HcommentController() {
		System.out.println(getClass().getName() + "()생성");
	}
	
}
