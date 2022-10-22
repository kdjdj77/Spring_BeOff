package com.lec.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rental/admin")
public class AdminRentalController {
	
	
	@GetMapping("/basic") 
	public void basic() {}
	
	@GetMapping("/list") 
	public void list() {}
	
	@GetMapping("/write") 
	public void write() {}
	
	@GetMapping("/update") 
	public void update() {}
	
	@GetMapping("/cars/list") 
	public String carsList() {
		
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
