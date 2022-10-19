package com.lec.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lec.spring.domain.qna.Qna;
import com.lec.spring.service.AirService;
import com.lec.spring.service.BoardService;
import com.lec.spring.util.U;

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
	

} // end controller