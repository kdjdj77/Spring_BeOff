package com.lec.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.spring.domain.air.AqryList;
import com.lec.spring.service.AirplaneService;

@RestController
@RequestMapping("/air/airplane")
public class AirplaneController {
	@Autowired
	private AirplaneService airplaneService;

	public AirplaneController() {
		System.out.println(getClass().getName() + "() 생성");
	}
	
	@PostMapping("/list")
	public AqryList airlist(
			String departregion, String arriveregion,
			String time, String num_person, String date) {
		String datestr = date.replaceAll("-", "");
		
		return airplaneService.search(departregion, arriveregion, time, num_person, Long.parseLong(datestr));	
	}
	

} // end controller