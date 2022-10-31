package com.lec.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;import com.lec.spring.domain.rental.Rental;
import com.lec.spring.service.AdminRentalService;

@Controller
@RequestMapping("/rental/admin")
public class AdminRentalController {
	
	@Autowired
	private AdminRentalService adminRentalService;
	
	public AdminRentalController() {
		System.out.println(getClass().getName() + "() 생성");
	}
	
	// rental/admin/list : 본인이 등록한 렌트업체 조회
	@GetMapping("/list") 
	public String rentalList(Model model) {
		List<Rental> list = adminRentalService.getRentalList();
		
		model.addAttribute("rentalList", list);
		
		return "/rental/admin/list";
	}
	
	// rental/admin/cars/list 선택한 업체에 해당하는 렌트카 조회
	@GetMapping("/cars/list") 
	public String carsList(String id, Model model) {
		Rental r = adminRentalService.getRentalById(id);
		model.addAttribute("r", r);
		
		return "/rental/admin/cars/list";
	}
	
	// 업체 등록
	@GetMapping("/rentalWrite") 
	public String rentalWrite(Model md) {
		List<String> list = adminRentalService.getRegionList();
		md.addAttribute("regionList", list);
		return "/rental/admin/rentalWrite";
	}
	
	//업체 등록 완료
	@PostMapping("rentalWriteOk")
	public String rentalWriteOk(String username, String rentalname, String region, String content, Model md) {
		int result = 0;
		result = adminRentalService.registerRental(username, rentalname, region, content);
		md.addAttribute("result", result);
		return "/rental/admin/rentalWriteOk";
	}
	
	//업체 수정
	@GetMapping("/rentalUpdate") 
	public String update(String id, Model md) {
		Rental r = adminRentalService.getRentalById(id);
		
		md.addAttribute("rental", r);
		
		return "/rental/admin/rentalUpdate";
	}
	
	@PostMapping("/rentalUpdateOk")
	public String rentalUpdateOk(String id, String rentalname, String content, Model md) {
		int result = adminRentalService.updateRental(id, rentalname, content);
		md.addAttribute(result);
		
		return "rental/admin/rentalUpdateOk";
	}	
	
	
	// 업체 삭제
	@GetMapping("/rentalDeleteOk")
	public String rentalDeleteOk(String id, Model md) {
		int result = adminRentalService.rentalDelete(id);
		md.addAttribute(result);
		
		return "rental/admin/rentalDeleteOk";
	}
	
	@GetMapping("/cars/carWrite") 
	public String carWrite(String id, Model md) {
		
		md.addAttribute("id", id);
		
		return "/rental/admin/cars/carWrite";
	}
	
//	@GetMapping("/cars/detail") 
//	public String carsDetail() {
//		
//		return "/rental/admin/cars/detail";
//	}
//	
	
//	@GetMapping("/cars/update") 
//	public String carsUpdate() {
//		
//		return "/rental/admin/cars/update";
//	}

}
