package com.lec.spring.repository.rental;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.User;
import com.lec.spring.domain.rental.Car;
import com.lec.spring.domain.rental.Carfile;
import com.lec.spring.domain.rental.Rental;
import com.lec.spring.domain.rental.Rentalticket;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;

@SpringBootTest
class CarRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdminRentalRepository rentalRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private CarfileRepository carfileRepository;
	
	@Autowired
	private RegionRepository regionRepository;
	
	@Autowired
	private RentalticketRepository rentalticketRepository;

	@Test
	void test() {
		User adminRental = userRepository.findByUsername("ADMINRENTAL");
		
		User user1 = userRepository.findByUsername("USER1");

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
	    
	    Car c1 = Car.builder().rental(r1).carname("모닝").price(50000).cartype("소형").fuel("가솔린").fueleff("복합 15.7km/L").build();
	    Car c2 = Car.builder().rental(r1).carname("소나타").price(80000).cartype("중형").fuel("가솔린/하이브리드").fueleff("복합 19.1km/L").build();
	    Car c3 = Car.builder().rental(r1).carname("GV80").price(100000).cartype("SUV").fuel("가솔린").fueleff("복합 8km/L").build();
	    Car c4 = Car.builder().rental(r1).carname("G90").price(150000).cartype("대형").fuel("가솔린").fueleff("복합 8.5km/L").build();
	    Car c5 = Car.builder().rental(r2).carname("모닝").price(50000).cartype("소형").fuel("가솔린").fueleff("복합 15.7km/L").build();
	    Car c6 = Car.builder().rental(r2).carname("소나타").price(80000).cartype("중형").fuel("가솔린/하이브리드").fueleff("복합 19.1km/L").build();
	    Car c7 = Car.builder().rental(r2).carname("GV80").price(100000).cartype("SUV").fuel("가솔린").fueleff("복합 8km/L").build();
	    Car c8 = Car.builder().rental(r2).carname("G90").price(150000).cartype("대형").fuel("가솔린").fueleff("복합 8.5km/L").build();
	    Car c9 = Car.builder().rental(r3).carname("모닝").price(50000).cartype("소형").fuel("가솔린").fueleff("복합 15.7km/L").build();
	    Car c10 = Car.builder().rental(r3).carname("소나타").price(80000).cartype("중형").fuel("가솔린/하이브리드").fueleff("복합 19.1km/L").build();
	    Car c11 = Car.builder().rental(r3).carname("GV80").price(100000).cartype("SUV").fuel("가솔린").fueleff("복합 8km/L").build();
	    Car c12 = Car.builder().rental(r3).carname("G90").price(150000).cartype("대형").fuel("가솔린").fueleff("복합 8.5km/L").build();
	    Car c13 = Car.builder().rental(r4).carname("모닝").price(50000).cartype("소형").fuel("가솔린").fueleff("복합 15.7km/L").build();
	    Car c14 = Car.builder().rental(r4).carname("소나타").price(80000).cartype("중형").fuel("가솔린/하이브리드").fueleff("복합 19.1km/L").build();
	    Car c15 = Car.builder().rental(r4).carname("GV80").price(100000).cartype("SUV").fuel("가솔린").fueleff("복합 8km/L").build();
	    Car c16 = Car.builder().rental(r4).carname("G90").price(150000).cartype("대형").fuel("가솔린").fueleff("복합 8.5km/L").build();
	    Car c17 = Car.builder().rental(r5).carname("모닝").price(50000).cartype("소형").fuel("가솔린").fueleff("복합 15.7km/L").build();
	    Car c18 = Car.builder().rental(r5).carname("소나타").price(80000).cartype("중형").fuel("가솔린/하이브리드").fueleff("복합 19.1km/L").build();
	    Car c19 = Car.builder().rental(r5).carname("GV80").price(100000).cartype("SUV").fuel("가솔린").fueleff("복합 8km/L").build();
	    Car c20 = Car.builder().rental(r5).carname("G90").price(150000).cartype("대형").fuel("가솔린").fueleff("복합 8.5km/L").build();
	    Car c21 = Car.builder().rental(r6).carname("모닝").price(50000).cartype("소형").fuel("가솔린").fueleff("복합 15.7km/L").build();
	    Car c22 = Car.builder().rental(r6).carname("소나타").price(80000).cartype("중형").fuel("가솔린/하이브리드").fueleff("복합 19.1km/L").build();
	    Car c23 = Car.builder().rental(r6).carname("GV80").price(100000).cartype("SUV").fuel("가솔린").fueleff("복합 8km/L").build();
	    Car c24 = Car.builder().rental(r6).carname("G90").price(150000).cartype("대형").fuel("가솔린").fueleff("복합 8.5km/L").build();
	    Car c25 = Car.builder().rental(r7).carname("모닝").price(50000).cartype("소형").fuel("가솔린").fueleff("복합 15.7km/L").build();
	    Car c26 = Car.builder().rental(r7).carname("소나타").price(80000).cartype("중형").fuel("가솔린/하이브리드").fueleff("복합 19.1km/L").build();
	    Car c27 = Car.builder().rental(r7).carname("GV80").price(100000).cartype("SUV").fuel("가솔린").fueleff("복합 8km/L").build();
	    Car c28 = Car.builder().rental(r7).carname("G90").price(150000).cartype("대형").fuel("가솔린").fueleff("복합 8.5km/L").build();
	    Car c29 = Car.builder().rental(r8).carname("모닝").price(50000).cartype("소형").fuel("가솔린").fueleff("복합 15.7km/L").build();
	    Car c30 = Car.builder().rental(r8).carname("소나타").price(80000).cartype("중형").fuel("가솔린/하이브리드").fueleff("복합 19.1km/L").build();
	    Car c31 = Car.builder().rental(r8).carname("GV80").price(100000).cartype("SUV").fuel("가솔린").fueleff("복합 8km/L").build();
	    Car c32 = Car.builder().rental(r8).carname("G90").price(150000).cartype("대형").fuel("가솔린").fueleff("복합 8.5km/L").build();
	    Car c33 = Car.builder().rental(r9).carname("모닝").price(50000).cartype("소형").fuel("가솔린").fueleff("복합 15.7km/L").build();
	    Car c34 = Car.builder().rental(r9).carname("소나타").price(80000).cartype("중형").fuel("가솔린/하이브리드").fueleff("복합 19.1km/L").build();
	    Car c35 = Car.builder().rental(r9).carname("GV80").price(100000).cartype("SUV").fuel("가솔린").fueleff("복합 8km/L").build();
	    Car c36 = Car.builder().rental(r9).carname("G90").price(150000).cartype("대형").fuel("가솔린").fueleff("복합 8.5km/L").build();
	    Car c37 = Car.builder().rental(r10).carname("모닝").price(50000).cartype("소형").fuel("가솔린").fueleff("복합 15.7km/L").build();
	    Car c38 = Car.builder().rental(r10).carname("소나타").price(80000).cartype("중형").fuel("가솔린/하이브리드").fueleff("복합 19.1km/L").build();
	    Car c39 = Car.builder().rental(r10).carname("GV80").price(100000).cartype("SUV").fuel("가솔린").fueleff("복합 8km/L").build();
	    Car c40 = Car.builder().rental(r10).carname("G90").price(150000).cartype("대형").fuel("가솔린").fueleff("복합 8.5km/L").build();
	    
	    // 일본 렌트카
	    Car c41 = Car.builder().rental(r11).carname("도요타 프리우스 C").price(60000).cartype("소형").fuel("가솔린/하이브리드").fueleff("복합 18.5km/L").build();
	    Car c42 = Car.builder().rental(r11).carname("혼다 어코드").price(90000).cartype("중형").fuel("가솔린").fueleff("복합 13.9km/L").build();
	    Car c43 = Car.builder().rental(r11).carname("렉서스 NX").price(120000).cartype("SUV").fuel("가솔린").fueleff("복합 14.3km/L").build();
	    Car c44 = Car.builder().rental(r11).carname("렉서스 LS").price(180000).cartype("대형").fuel("가솔린/하이브리드").fueleff("복합 9.6km/L").build();
	    Car c45 = Car.builder().rental(r12).carname("도요타 프리우스 C").price(60000).cartype("소형").fuel("가솔린/하이브리드").fueleff("복합 18.5km/L").build();
	    Car c46 = Car.builder().rental(r12).carname("혼다 어코드").price(90000).cartype("중형").fuel("가솔린").fueleff("복합 13.9km/L").build();
	    Car c47 = Car.builder().rental(r12).carname("렉서스 NX").price(120000).cartype("SUV").fuel("가솔린").fueleff("복합 14.3km/L").build();
	    Car c48 = Car.builder().rental(r12).carname("렉서스 LS").price(180000).cartype("대형").fuel("가솔린/하이브리드").fueleff("복합 9.6km/L").build();
	   
	    // 미국 렌트카
	    Car c49 = Car.builder().rental(r13).carname("쉐보레 볼트 EV").price(70000).cartype("소형").fuel("전기").fueleff("복합 5.4km/L").build();
	    Car c50 = Car.builder().rental(r13).carname("테슬라 모델3").price(100000).cartype("중형").fuel("전기").fueleff("복합 5.1km/L").build();
	    Car c51 = Car.builder().rental(r13).carname("캐딜락 XT4").price(150000).cartype("SUV").fuel("가솔린").fueleff("복합 10.0km/L").build();
	    Car c52 = Car.builder().rental(r13).carname("링컨 컨티넨탈").price(200000).cartype("대형").fuel("가솔린").fueleff("복합 7.5km/L").build();
	    Car c53 = Car.builder().rental(r14).carname("쉐보레 볼트 EV").price(70000).cartype("소형").fuel("전기").fueleff("복합 5.4km/L").build();
	    Car c54 = Car.builder().rental(r14).carname("테슬라 모델3").price(100000).cartype("중형").fuel("전기").fueleff("복합 5.1km/L").build();
	    Car c55 = Car.builder().rental(r14).carname("캐딜락 XT4").price(150000).cartype("SUV").fuel("가솔린").fueleff("복합 10.0km/L").build();
	    Car c56 = Car.builder().rental(r14).carname("링컨 컨티넨탈").price(200000).cartype("대형").fuel("가솔린").fueleff("복합 7.5km/L").build();
	    Car c57 = Car.builder().rental(r15).carname("쉐보레 볼트 EV").price(70000).cartype("소형").fuel("전기").fueleff("복합 5.4km/L").build();
	    Car c58 = Car.builder().rental(r15).carname("테슬라 모델3").price(100000).cartype("중형").fuel("전기").fueleff("복합 5.1km/L").build();
	    Car c59 = Car.builder().rental(r15).carname("캐딜락 XT4").price(150000).cartype("SUV").fuel("가솔린").fueleff("복합 10.0km/L").build();
	    Car c60 = Car.builder().rental(r15).carname("링컨 컨티넨탈").price(200000).cartype("대형").fuel("가솔린").fueleff("복합 7.5km/L").build();
	    
	    c1 = carRepository.save(c1);
	    c2 = carRepository.save(c2);
	    c3 = carRepository.save(c3);
	    c4 = carRepository.save(c4);
	    c5 = carRepository.save(c5);
	    c6 = carRepository.save(c6);
	    c7 = carRepository.save(c7);
	    c8 = carRepository.save(c8);
	    c9 = carRepository.save(c9);
	    c10 = carRepository.save(c10);
	    c11 = carRepository.save(c11);
	    c12 = carRepository.save(c12);
	    c13 = carRepository.save(c13);
	    c14 = carRepository.save(c14);
	    c15 = carRepository.save(c15);
	    c16 = carRepository.save(c16);
	    c17 = carRepository.save(c17);
	    c18 = carRepository.save(c18);
	    c19 = carRepository.save(c19);
	    c20 = carRepository.save(c20);
	    c21 = carRepository.save(c21);
	    c22 = carRepository.save(c22);
	    c23 = carRepository.save(c23);
	    c24 = carRepository.save(c24);
	    c25 = carRepository.save(c25);
	    c26 = carRepository.save(c26);
	    c27 = carRepository.save(c27);
	    c28 = carRepository.save(c28);
	    c29 = carRepository.save(c29);
	    c30 = carRepository.save(c30);
	    c31 = carRepository.save(c31);
	    c32 = carRepository.save(c32);
	    c33 = carRepository.save(c33);
	    c34 = carRepository.save(c34);
	    c35 = carRepository.save(c35);
	    c36 = carRepository.save(c36);
	    c37 = carRepository.save(c37);
	    c38 = carRepository.save(c38);
	    c39 = carRepository.save(c39);
	    c40 = carRepository.save(c40);
	    c41 = carRepository.save(c41);
	    c42 = carRepository.save(c42);
	    c43 = carRepository.save(c43);
	    c44 = carRepository.save(c44);
	    c45 = carRepository.save(c45);
	    c46 = carRepository.save(c46);
	    c47 = carRepository.save(c47);
	    c48 = carRepository.save(c48);
	    c49 = carRepository.save(c49);
	    c50 = carRepository.save(c50);
	    c51 = carRepository.save(c51);
	    c52 = carRepository.save(c52);
	    c53 = carRepository.save(c53);
	    c54 = carRepository.save(c54);
	    c55 = carRepository.save(c55);
	    c56 = carRepository.save(c56);
	    c57 = carRepository.save(c57);
	    c58 = carRepository.save(c58);
	    c59 = carRepository.save(c59);
	    c60 = carRepository.save(c60);
	    
	    carRepository.findAll().forEach(System.out::println);
	    
//	    Carfile cf1 = Carfile.builder().file("car1.jpg").source("car1.jpg").car_id(c1.getId()).build();
//	    Carfile cf2 = Carfile.builder().file("car2.jpg").source("car2.jpg").car_id(c2.getId()).build();
//	    Carfile cf3 = Carfile.builder().file("car3.jpg").source("car3.jpg").car_id(c3.getId()).build();
//	    Carfile cf4 = Carfile.builder().file("car4.jpg").source("car4.jpg").car_id(c4.getId()).build();
	    
	    Rentalticket t1 = Rentalticket.builder().user(user1).car(c5).date(20221212L).build();
	    Rentalticket t2 = Rentalticket.builder().user(user1).car(c6).date(20221212L).build();
	    Rentalticket t3 = Rentalticket.builder().user(user1).car(c7).date(20221212L).build();
	    Rentalticket t4 = Rentalticket.builder().user(user1).car(c8).date(20221212L).build();
	    Rentalticket t5 = Rentalticket.builder().user(user1).car(c9).date(20221212L).build();
	    
	    t1 = rentalticketRepository.save(t1);
	    t2 = rentalticketRepository.save(t2);
	    t3 = rentalticketRepository.save(t3);
	    t4 = rentalticketRepository.save(t4);
	    t5 = rentalticketRepository.save(t5);
    
	}

}
