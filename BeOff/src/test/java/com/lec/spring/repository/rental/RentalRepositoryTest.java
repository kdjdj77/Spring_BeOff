package com.lec.spring.repository.rental;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.User;
import com.lec.spring.domain.rental.Rental;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;

@SpringBootTest
class RentalRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdminRentalRepository rentalRepository;
	
	@Autowired
	private RegionRepository regionRepository;
	

	@Test
	void init() {
		User adminRental = userRepository.findByUsername("ADMINRENTAL");

	    Region korea = regionRepository.findByRegion("한국");
	    Region japan = regionRepository.findByRegion("일본");
	    Region usa = regionRepository.findByRegion("미국");
	    
	    // 렌트카 업체 입력
	    
	    Rental r1 = Rental.builder().rentalname("SK렌터카").content("차량관리는 프로가 하니까").user(adminRental).region(korea).avgstar(0).build();
	    Rental r2 = Rental.builder().rentalname("렌트킹").content("3만원 할인쿠폰 지급").user(adminRental).region(korea).avgstar(0).build();
	    Rental r3 = Rental.builder().rentalname("롯데오토리스").content("합리적인 롯데오토리스").user(adminRental).region(korea).avgstar(0).build();
	    Rental r4 = Rental.builder().rentalname("레드캡").content("레드캡에게 맡기고 운전만 하세요").user(adminRental).region(korea).avgstar(0).build();
	    Rental r5 = Rental.builder().rentalname("분당렌트카").content("타사대비 저렴한 비용").user(adminRental).region(korea).avgstar(0).build();
	    Rental r6 = Rental.builder().rentalname("이삭렌트카").content("K5소나타 일4만,월50/아반떼 일3만,월45").user(adminRental).region(korea).avgstar(0).build();
	    Rental r7 = Rental.builder().rentalname("카모아").content("가격비교, 결제까지 3분이면 끝!전국어디서나 카모아").user(adminRental).region(korea).avgstar(0).build();
	    Rental r8 = Rental.builder().rentalname("도윤렌트카").content("24시간 빠르고 친절한 렌트카 최신형차량 좋은가격!").user(adminRental).region(korea).avgstar(0).build();
	    Rental r9 = Rental.builder().rentalname("KB차차차").content("렌트카 특가할인! 일단의 신차 특가!").user(adminRental).region(korea).avgstar(0).build();
	    Rental r10 = Rental.builder().rentalname("조아렌트카").content("서울/경기 24시간 최신차량 배차가능, 고객맞춤 렌트 서비스").user(adminRental).region(korea).avgstar(0).build();
	    Rental r11 = Rental.builder().rentalname("와이드렌트카").content("일본 전국 렌트카 3210엔/24시간부터, 세금 및 면책보험 포함, 추가2%포인트").user(adminRental).region(japan).avgstar(0).build();
	    Rental r12 = Rental.builder().rentalname("KAYAK").content("여행꿀팁/맞춤상품 제공!").user(adminRental).region(japan).avgstar(0).build();
	    Rental r13 = Rental.builder().rentalname("LA공항 엔와이").content("원하는곳 어디든지 딜리버리").user(adminRental).region(usa).avgstar(0).build();
	    Rental r14 = Rental.builder().rentalname("알라모 렌트카").content("보험이 포함된 합리적인 요금제, 알라모 렌트카와 함께 안전한 여행하세요!").user(adminRental).region(usa).avgstar(0).build();
	    Rental r15 = Rental.builder().rentalname("케이타운").content("24시간 상담 한인 직원 대기, 무료 공항 픽업, LA 여행 믿을 수 있는 업체").user(adminRental).region(usa).avgstar(0).build();
	    
	    r1 = rentalRepository.save(r1);
	    r2 = rentalRepository.save(r2);
	    r3 = rentalRepository.save(r3);
	    r4 = rentalRepository.save(r4);
	    r5 = rentalRepository.save(r5);
	    r6 = rentalRepository.save(r6);
	    r7 = rentalRepository.save(r7);
	    r8 = rentalRepository.save(r8);
	    r9 = rentalRepository.save(r9);
	    r10 = rentalRepository.save(r10);
	    r11 = rentalRepository.save(r11);
	    r12 = rentalRepository.save(r12);
	    r13 = rentalRepository.save(r13);
	    r14 = rentalRepository.save(r14);
	    r15 = rentalRepository.save(r15);
	    
	    rentalRepository.findAll().forEach(System.out::println);
	}

}
