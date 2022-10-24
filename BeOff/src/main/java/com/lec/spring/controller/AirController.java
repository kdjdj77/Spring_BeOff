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
	@Autowired
	private AirService airService;
	public AirController() {System.out.println(getClass().getName() + "() 생성");}
	
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
		model.addAttribute("departregion2", arriveregion);
		model.addAttribute("arriveregion2", departregion);
		model.addAttribute("departdate2", arrivedate);
		model.addAttribute("num_person2", num_person);
		
		
		return "air/roundtime";
	}
	
	@PostMapping("/onewayReserv")
	public String oSelectSeat(
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
	
	@PostMapping("/roundReserv")
	public String rSelectSeat(
			String air_id, String departdate, String num_person,
			String air_id2, String departdate2, String num_person2,
			Model model) {
		String datestr = departdate.replaceAll("-", "");
		Long date = Long.parseLong(datestr);
		Long airId = Long.parseLong(air_id);
		
		
		model.addAttribute("airplane", airService.getAirplaneById(airId));
		model.addAttribute("num", num_person);
		model.addAttribute("date", departdate);
		model.addAttribute("reserved", airService.getTicketSeatList(airId, date));
		
		String datestr2 = departdate2.replaceAll("-", "");
		Long date2 = Long.parseLong(datestr2);
		Long airId2 = Long.parseLong(air_id2);
		
		model.addAttribute("airplane2", airService.getAirplaneById(airId2));
		model.addAttribute("num2", num_person2);
		model.addAttribute("date2", departdate2);
		model.addAttribute("reserved2", airService.getTicketSeatList(airId2, date2));
		
		return "air/roundReserv";
	}
	
	@PostMapping("/onewayReservOk")
	public String onewayReservOk(
			@RequestParam List<String> seats, 
			String id, String departDate, Model model) {
		List<String> seatList = seats;
		String dDate = departDate.replaceAll("-", "");
		
		int result = airService.registerSeats(seatList, id, dDate);
		model.addAttribute("result", result);
		
		return "air/reservOk";
	}
	
	@PostMapping("/roundReservOk")
	public String roundReservOk(
			@RequestParam List<String> seats, 
			String id, String departDate, 
			@RequestParam List<String> seats2, 
			String id2, String departDate2, 
			Model model) {
		List<String> seatList = seats;
		String dDate = departDate.replaceAll("-", "");
		
		List<String> seatList2 = seats2;
		String dDate2 = departDate2.replaceAll("-", "");
		
		int result = airService.registerSeats(seatList, id, dDate);
		int result2 = airService.registerSeats(seatList2, id2, dDate2);
		
		if (result == 1 && result2 == 1) result = 1;
		else result = 0;
		
		model.addAttribute("result", result);
		
		return "air/reservOk";
	}
	
	@GetMapping("/admin/list")
	public String adminList(Model model) {		
		model.addAttribute("regionList", airService.getRegionList());
		model.addAttribute("nameList", airService.getAirNameList());
		model.addAttribute("timeList", airService.getAirTimeList());
		
		return "air/admin/list";
	}
	
	
} // end controller