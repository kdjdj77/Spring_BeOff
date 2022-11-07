package com.lec.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.lec.spring.domain.User;
import com.lec.spring.domain.hotel.Hcomment;
import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.domain.hotel.HqryCommentList;
import com.lec.spring.domain.hotel.HqryResult;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.hotel.HcommentRepository;
import com.lec.spring.repository.hotel.HotelRepository;

@Service
public class HcommentService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private HcommentRepository hcommentRepository;
	
	
	//특정 호텔의 댓글 목록
	public HqryCommentList list(Hotel hotelId) {
		HqryCommentList list = new HqryCommentList();
		List<Hcomment> hcomments = null;
		hcomments = hcommentRepository.findByHotel(hotelId, Sort.by(Order.desc("regDate")));
		list.setCount(hcomments.size());
		list.setList(hcomments);
		list.setStatus("OK");
		
		return list;
	}
	
	//특정 호텔의 특정 사용자 가 댓글 작성
	
	public HqryResult write(Hotel hotelId, Long UserId, String content, Long star) {
		User user = userRepository.findById(UserId).orElse(null);
		
		Hcomment hcomment = Hcomment.builder()
				.user(user)
				.content(content)
				.hotel(hotelId)
				.star(star)
				.build()
				;
		
		hcommentRepository.save(hcomment);
		HqryResult result = HqryResult.builder()
					.count(1)
					.status("OK")
					.build()
					;
		
		return result;
	}
	
	//특정 댓글 삭제
	
	
	public HqryResult delete(Long id) {
		Hcomment hcomment = hcommentRepository.findById(id).orElse(null);
		
		int count = 0 ;
		String status = "FAIL";
		
		if(hcomment != null) {
			hcommentRepository.delete(hcomment);
			count = 1;
			status = "OK";
		}
		
		HqryResult result = HqryResult.builder()
				.count(count)
				.status(status)
				.build()
				;
		
		return result;
	}
	
	
	
	
	
	
	
	
	
}
