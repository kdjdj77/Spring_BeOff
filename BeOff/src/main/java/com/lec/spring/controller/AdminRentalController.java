package com.lec.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.spring.domain.rental.Rental;
import com.lec.spring.service.AdminRentalService;

@Controller
@RequestMapping("/rental/admin")
public class AdminRentalController {
	
	@Autowired
	private AdminRentalService adminRentalService;
	
	public AdminRentalController() {
		System.out.println(getClass().getName() + "() 생성");
	}
	
	@GetMapping("/list") 
	public String rentallist(Model model) {
		List<Rental> list = adminRentalService.getRentalList();
		
		model.addAttribute("carList", adminRentalService.getCarList());
		model.addAttribute("rentalList", list);
		
		System.out.println(list);
		
		return "/rental/admin/list";
	}
	
	@GetMapping("/write") 
	public void write() {}
	
	@GetMapping("/update") 
	public void update() {}
	
	@GetMapping("/cars/list") 
	public String carsList(String id, Model model) {
		Rental r = adminRentalService.getRentalById(id);
		model.addAttribute("carList", r);
		
		return "/rental/admin/cars/list";
	}
	
	@GetMapping("/cars/detail") 
	public String carsDetail() {
		
		return "/rental/admin/cars/detail";
	}
	
	@GetMapping("/cars/write") 
	public String carsWrite() {
		
		return "/rental/admin/cars/write";
	}
	
	@GetMapping("/cars/update") 
	public String carsUpdate() {
		
		return "/rental/admin/cars/update";
	}

}
