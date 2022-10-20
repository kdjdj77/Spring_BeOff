package com.lec.spring.service.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.hotel.HcommentRepository;

@Service
public class HcommentService {
	@Autowired
	private HcommentRepository hcommentRepository;
	@Autowired
	private UserRepository userRepository;
	
	public HcommentService() {
		System.out.println(getClass().getName() + "()생성");
	}
}
