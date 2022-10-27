package com.lec.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.spring.domain.hotel.HqryCommentList;
import com.lec.spring.domain.hotel.HqryResult;
import com.lec.spring.service.HotelService;

@RestController
@RequestMapping("/hcomment")
public class HcommentController {
	@Autowired
	private HotelService hotelService;
	
	public HcommentController() {
		System.out.println(getClass().getName() + "()생성");
	}
	
	@GetMapping("/list")
	public HqryCommentList getCommentList(Long id) {
		return hotelService.getCommentList(id);
		}
//	@PostMapping("/wrtie")
//	public HqryResult write(
//			
//			);
	
}
