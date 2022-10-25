package com.lec.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.spring.service.RentalService;

@Controller
@RequestMapping("/rental")
public class RentalController {
	@Autowired
	private RentalService rentalService;
	
	public void setRentalService(RentalService rentalService) {
		this.rentalService = rentalService;
	}

    public RentalController() {
       System.out.println(getClass().getName() + "() 생성");
    }
   
	
	@GetMapping("/list") // /rental/list
	public String list(Model model) {
		model.addAttribute("regionList", rentalService.getRegionList());
		model.addAttribute("rentalList", rentalService.getRentalList());
		
		return "/rental/list";
	}
	
	@PostMapping("/cars/list") // /rental/cars/list
	public String carsList(String rentalId, Model model) {
		model.addAttribute("rental", rentalService.getRentalById(rentalId));
		model.addAttribute("regionList", rentalService.getRegionList());
		model.addAttribute("rentalList", rentalService.getRentalList());
//		model.addAttribute("carNameList", rentalService.getCarNameList());
		return "rental/cars/list";
		
	}
	
	@GetMapping("/cars/detail") // /rental/cars/detail
	public String carsDetail(String rentalId, Model model) {
		model.addAttribute("rental", rentalService.getRentalById(rentalId));
		model.addAttribute("regionList", rentalService.getRegionList());
		model.addAttribute("rentalList", rentalService.getRentalList());
		return "rental/cars/detail";
	}
	
	@GetMapping("/reserv") // /rental/reserv
	public void reserv() {}
	
	
	
	

}
