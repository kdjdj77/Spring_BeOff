package com.lec.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.domain.hotel.HqryCommentList;
import com.lec.spring.domain.hotel.HqryResult;
import com.lec.spring.service.HcommentService;
import com.lec.spring.service.HotelService;

@RestController
@RequestMapping("/hcomment")
public class HcommentController {

	@Autowired
	private HcommentService hcommentService;
	
	public HcommentController() {
		System.out.println(getClass().getName() + "()생성");
	}
	
	@GetMapping("/list")
	public HqryCommentList list(Hotel hotelId) {
		return hcommentService.list(hotelId);
	}
	
	@PostMapping("/write")
	public HqryResult write(
			@RequestParam("hotel_id") Hotel hotelId,
			@RequestParam("user_id") Long userId,
			String content,
			Long star) {
		return hcommentService.write(hotelId, userId, content, star);
	}
	
	@PostMapping("/delete")
	public HqryResult delete(Long id) {
		return hcommentService.delete(id);
	}
	
}
