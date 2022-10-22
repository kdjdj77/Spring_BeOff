package com.lec.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.spring.service.rental.RentalService;

@Controller
@RequestMapping("/rental")
public class RentalController {

   public RentalController() {
      System.out.println(getClass().getName() + "() 생성");
   }
   
   	
	@GetMapping("/basic") // /rental/basic
	public void basic() {}
	
	@GetMapping("/list") // /rental/list
	public void list() {}
	
	@GetMapping("/cars/list") // /rental/cars/list
	public String carsList() {
		
		return "rental/cars/list";
		
	}
	
	@GetMapping("/cars/detail") // /rental/cars/datail
	public String carsDetail() {
		
		return "rental/cars/datail";
	}
	
	@GetMapping("/reserv") // /rental/reserv
	public void reserv() {}
	
	
	
	

}
