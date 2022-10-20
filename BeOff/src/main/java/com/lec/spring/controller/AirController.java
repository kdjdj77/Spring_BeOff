package com.lec.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.spring.service.AirService;

@Controller
@RequestMapping("/air")
public class AirController {
	
	private AirService airService;
	
	@Autowired
	public void setAirService(AirService airService) {
		this.airService = airService;
	}

	public AirController() {
		System.out.println(getClass().getName() + "() 생성");
	}
	
	@GetMapping("/basic")
	public String basic(Model model) {
		model.addAttribute("regionList", airService.getRegionList());
		return "air/basic";
	}
	@PostMapping("/settime")
	public String chkround(
			String departregion, String arriveregion, String departdate,
			String arrivedate, String round_oneway, String num_person,
			Model model) {
		model.addAttribute("departregion", departregion);
		model.addAttribute("arriveregion", arriveregion);
		model.addAttribute("departdate", departdate);
		model.addAttribute("num_person", num_person);
		model.addAttribute("timeList", airService.getAirTimeList());
		if (round_oneway.equals("oneway")) {
			
			return "air/onewaytime";
		}
		model.addAttribute("arrivedate", departdate);
		
		
		return "air/roundtime";
	}
	

} // end controller