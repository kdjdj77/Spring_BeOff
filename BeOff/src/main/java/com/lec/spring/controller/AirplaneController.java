package com.lec.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.spring.domain.air.AqryList;
import com.lec.spring.service.AirService;

@RestController
@RequestMapping("/air/airplane")
public class AirplaneController {
	@Autowired
	private AirService airService;

	public AirplaneController() {
		System.out.println(getClass().getName() + "() 생성");
	}
	
	@PostMapping("/list")
	public AqryList airlist(
			String departregion, String arriveregion,
			String time, String num_person, String date) {
		String datestr = date.replaceAll("-", "");
		
		
		AqryList search = airService.search(departregion, arriveregion, time, num_person, Long.parseLong(datestr));
		return search;	
	}
	

} // end controller