package com.lec.spring.controller;

import java.util.List;
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

import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.domain.hotel.Room;
import com.lec.spring.service.AdminHotelService;

@Controller
@RequestMapping("/hotel/admin")
public class AdminHotelController {

	@Autowired
	private AdminHotelService adminHotelService;

	public AdminHotelController() {
		System.out.println(getClass().getName() + "() 생성");
	}	

	// hotel/admin/list : 로그인 한 관리자(adminhotel) "본인"이 등록한 모든 호텔 리스트 조회
	@GetMapping("/list")
	public String getHotelList(Model model) {
		
		List<Hotel> list = adminHotelService.getHotelList();
		
		model.addAttribute("roomList", adminHotelService.getRoomList());
		
		model.addAttribute("hotelList", list);
		System.out.println(list);
		
		return "/hotel/admin/list";
	}
	
	// hotel/admin/roomList : 선택한 호텔의 모든 룸 리스트 조회
	@GetMapping("/roomList")
	public String getRoomList(String id, Model model) {
		
		Hotel h = adminHotelService.getHotelById(id);
		
		model.addAttribute("roomList", h);
		System.out.println("roomList h ? "+h.getRooms());
		return "/hotel/admin/roomList";
	}
	
	// hotel/admin/hotelWrite : 호텔 등록 
	@GetMapping("/hotelWrite")
	public String writeHotel(Model model) {
		List<String> list = adminHotelService.getRegionList();
		model.addAttribute("regionList", list);
		return "/hotel/admin/hotelWrite";
	}
	
	// hotel/admin/roomWrite : 룸 등록 : 선택한 호텔의 룸
	@GetMapping("/roomWrite")
	public String roomWrite(String id, Model model) {
		
		System.out.println("id : "+ id);
		
		model.addAttribute("id", id);
		
		return "/hotel/admin/roomWrite";
	}
	
	// hotel/admin/hotelWriteOk : 호텔 등록 완료
	@PostMapping("/hotelWriteOk")
	public String writeOk(String username, String hotelname, String region, String content, Model model) {
		int result = 0;
		result = adminHotelService.registerHotel(username, hotelname, region, content);
		model.addAttribute("result", result);
		return "/hotel/admin/hotelWriteOk";
	}
	
	// hotel/admin/roomWriteOk : 룸 등록 완료
	@PostMapping("/roomWriteOk")
	public String writeOk(
			@RequestParam Map<String, MultipartFile> files // 첨부파일들
			,String id, String roomname, Double price, Long bed
			, Model model) {
		
		model.addAttribute("result", adminHotelService.registerRoom(id, roomname, price, bed, files));
		
		return "/hotel/admin/roomWriteOk";
	}
	
	
	// hotel/admin/update : 호텔, 방 업데이트
	@GetMapping("/update")
	public String update(String id, Model model) {
		
		Hotel h = adminHotelService.getHotelById(id);
		List<String> list = adminHotelService.getRegionList();
		
		model.addAttribute("regionList", list);
		model.addAttribute("hotel", h);
//		System.out.println("여기 뜨는게 중요함 "+h.getRooms()); 이러면 해당 호텔의 방의 정보도 넘어가는게 맞음

		return "/hotel/admin/update";
	}

	@PostMapping("/hotelUpdateOk") // 호텔 업데이트 완료
	public String hotelUpdateOk(String id, String hotelname, String region, String content, Model model) {
		int result = adminHotelService.updateHotel(id, hotelname, region, content);
		model.addAttribute(result);
		
		return "hotel/admin/hotelUpdateOk";
	}
	
//	@PostMapping("/roomUpdateOk") // 룸 업데이트 완료
//	public String roomUpdateOk(
//			String id, String roomname, Double price, Long bed, Model model,
//			@RequestParam Map<String, MultipartFile> files
//			) {
//		int result = adminHotelService.updateRoom(id, roomname, price, bed, files);
//		model.addAttribute(result);
//		
//		return "hotel/admin/roomUpdateOk";
//	}
	
	
	// 파일 업데이트 테스트중
//	@PostMapping("/roomUpdateOk") // 룸 업데이트 완료
//	public String roomUpdateOk(
//			@RequestParam Map<String, MultipartFile> files,
//			String id, String roomname, 
//			Double price, Long bed, Model model) {
//		
//		int result = adminHotelService.updateRoom(id, roomname, price, bed, files);
//		model.addAttribute(result);
//		
//		return "hotel/admin/roomUpdateOk";
//	}

	
	
	// 파일 업데이트 2차 테스트중 - 지금 파일 DB로 등록까지는 되는데 기존에 있던 파일 물리적, DB 삭제해야함
	@PostMapping("/roomUpdateOk") // 룸 업데이트 완료
	public String roomUpdateOk(
			@RequestParam Map<String, MultipartFile> files,
			String id, String roomname, 
			Double price, Long bed, Model model) {
		
		int result = adminHotelService.updateRoom(id, roomname, price, bed, files);
		model.addAttribute(result);
		
		return "hotel/admin/roomUpdateOk";
	}
	
	
	
	@GetMapping("/delete") // 호텔 삭제 완료
	public String hotelDeleteOk(String id, Model model) {
		int result = adminHotelService.deleteHotel(id);
		model.addAttribute(result);
		
		return "hotel/admin/deleteOk";
	}
	
	@GetMapping("/roomDelete") // 룸 삭제 완료
	public String roomDeleteOk(String id, Model model) {
		System.out.println("컨트롤러에서 id "+id);
		int result = adminHotelService.deleteRoom(id);
		model.addAttribute(result);
		
		return "hotel/admin/deleteOk";
	}
}
