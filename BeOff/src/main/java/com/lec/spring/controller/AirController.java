package com.lec.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@PostMapping("/onewayReserv")
	public String selectSeat(
			String air_id, String departdate, String num_person,
			Model model) {
		String datestr = departdate.replaceAll("-", "");
		Long airId = Long.parseLong(air_id);
		Long date = Long.parseLong(datestr);
		
		model.addAttribute("airplane", airService.getAirplaneById(airId));
		model.addAttribute("num", num_person);
		model.addAttribute("date", departdate);
		model.addAttribute("reserved", airService.getTicketSeatList(airId, date));
		
		return "air/onewayReserv";
	}
	
	@PostMapping("/onewayReservOk")
	public String onewayReservOk(
			@RequestParam List<String> seats, 
			String id, String departDate, Model model) {
		List<String> seatList = seats;
		String dDate = departDate.replaceAll("-", "");
		
		int result = airService.registerSeats(seatList, id, dDate);
		model.addAttribute("result", result);
		
		return "air/onewayReservOk";
	}
} // end controller