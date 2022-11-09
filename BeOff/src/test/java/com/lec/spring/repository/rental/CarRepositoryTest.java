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
	    Car c5 = Car.builder().rental(r2).carname("펠리세이드").price(90000).cartype("SUV").fuel("가솔린").fueleff("복합 8.5km/L").build();
	    Car c6 = Car.builder().rental(r2).carname("소나타").price(80000).cartype("중형").fuel("가솔린/하이브리드").fueleff("복합 19.1km/L").build();
	    Car c7 = Car.builder().rental(r2).carname("GV80").price(100000).cartype("SUV").fuel("가솔린").fueleff("복합 8km/L").build();
	    Car c8 = Car.builder().rental(r2).carname("G90").price(150000).cartype("대형").fuel("가솔린").fueleff("복합 8.5km/L").build();
	    Car c9 = Car.builder().rental(r3).carname("스포티지").price(90000).cartype("SUV").fuel("가솔린").fueleff("복합 9km/L").build();
	    Car c10 = Car.builder().rental(r3).carname("소나타").price(80000).cartype("중형").fuel("가솔린/하이브리드").fueleff("복합 19.1km/L").build();
	    Car c11 = Car.builder().rental(r3).carname("GV80").price(100000).cartype("SUV").fuel("가솔린").fueleff("복합 8km/L").build();
	    Car c12 = Car.builder().rental(r3).carname("G90").price(150000).cartype("대형").fuel("가솔린").fueleff("복합 8.5km/L").build();
	    Car c13 = Car.builder().rental(r4).carname("GV80").price(150000).cartype("SUV").fuel("가솔린").fueleff("복합 8km/L").build();
	    Car c14 = Car.builder().rental(r4).carname("소나타").price(80000).cartype("중형").fuel("가솔린/하이브리드").fueleff("복합 19.1km/L").build();
	    Car c15 = Car.builder().rental(r4).carname("GV80").price(100000).cartype("SUV").fuel("가솔린").fueleff("복합 8km/L").build();
	    Car c16 = Car.builder().rental(r4).carname("G90").price(150000).cartype("대형").fuel("가솔린").fueleff("복합 8.5km/L").build();
	    Car c17 = Car.builder().rental(r5).carname("K9").price(130000).cartype("대형").fuel("가솔린").fueleff("복합 8.1km/L").build();
	    Car c18 = Car.builder().rental(r5).carname("소나타").price(80000).cartype("중형").fuel("가솔린/하이브리드").fueleff("복합 19.1km/L").build();
	    Car c19 = Car.builder().rental(r5).carname("GV80").price(100000).cartype("SUV").fuel("가솔린").fueleff("복합 8km/L").build();
	    Car c20 = Car.builder().rental(r5).carname("G90").price(150000).cartype("대형").fuel("가솔린").fueleff("복합 8.5km/L").build();
	    Car c21 = Car.builder().rental(r6).carname("K5").price(60000).cartype("중형").fuel("가솔린").fueleff("복합 9.8km/L").build();
	    Car c22 = Car.builder().rental(r6).carname("소나타").price(80000).cartype("중형").fuel("가솔린/하이브리드").fueleff("복합 19.1km/L").build();
	    Car c23 = Car.builder().rental(r6).carname("GV80").price(100000).cartype("SUV").fuel("가솔린").fueleff("복합 8km/L").build();
	    Car c24 = Car.builder().rental(r6).carname("G90").price(150000).cartype("대형").fuel("가솔린").fueleff("복합 8.5km/L").build();
	    Car c25 = Car.builder().rental(r7).carname("미니쿠페").price(50000).cartype("소형").fuel("가솔린").fueleff("복합 15.2km/L").build();
	    Car c26 = Car.builder().rental(r7).carname("소나타").price(80000).cartype("중형").fuel("가솔린/하이브리드").fueleff("복합 19.1km/L").build();
	    Car c27 = Car.builder().rental(r7).carname("GV80").price(100000).cartype("SUV").fuel("가솔린").fueleff("복합 8km/L").build();
	    Car c28 = Car.builder().rental(r7).carname("G90").price(150000).cartype("대형").fuel("가솔린").fueleff("복합 8.5km/L").build();
	    Car c29 = Car.builder().rental(r8).carname("소렌토").price(90000).cartype("SUV").fuel("가솔린").fueleff("복합 9.7km/L").build();
	    Car c30 = Car.builder().rental(r8).carname("소나타").price(80000).cartype("중형").fuel("가솔린/하이브리드").fueleff("복합 19.1km/L").build();
	    Car c31 = Car.builder().rental(r8).carname("GV80").price(100000).cartype("SUV").fuel("가솔린").fueleff("복합 8km/L").build();
	    Car c32 = Car.builder().rental(r8).carname("G90").price(150000).cartype("대형").fuel("가솔린").fueleff("복합 8.5km/L").build();
	    Car c33 = Car.builder().rental(r9).carname("카니발").price(180000).cartype("대형").fuel("가솔린").fueleff("복합 8.4km/L").build();
	    Car c34 = Car.builder().rental(r9).carname("소나타").price(80000).cartype("중형").fuel("가솔린/하이브리드").fueleff("복합 19.1km/L").build();
	    Car c35 = Car.builder().rental(r9).carname("GV80").price(100000).cartype("SUV").fuel("가솔린").fueleff("복합 8km/L").build();
	    Car c36 = Car.builder().rental(r9).carname("G90").price(150000).cartype("대형").fuel("가솔린").fueleff("복합 8.5km/L").build();
	    Car c37 = Car.builder().rental(r10).carname("스팅어").price(160000).cartype("중형").fuel("가솔린").fueleff("복합 8.5km/L").build();
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
	    
	    
	    Carfile cf1 = Carfile.builder().file("car1.jpg").source("car1.jpg").car(c1.getId()).build();
	    Carfile cf2 = Carfile.builder().file("car2.jpg").source("car2.jpg").car(c2.getId()).build();
	    Carfile cf3 = Carfile.builder().file("car3.jpg").source("car3.jpg").car(c3.getId()).build();
	    Carfile cf4 = Carfile.builder().file("car4.jpg").source("car4.jpg").car(c4.getId()).build();
	    Carfile cf5 = Carfile.builder().file("pel1.jpg").source("pel1.jpg").car(c5.getId()).build();
	    Carfile cf6 = Carfile.builder().file("car2.jpg").source("car2.jpg").car(c6.getId()).build();
	    Carfile cf7 = Carfile.builder().file("car3.jpg").source("car3.jpg").car(c7.getId()).build();
	    Carfile cf8 = Carfile.builder().file("car4.jpg").source("car4.jpg").car(c8.getId()).build();
	    Carfile cf9 = Carfile.builder().file("spo.jpg").source("spo.jpg").car(c9.getId()).build();
	    Carfile cf10 = Carfile.builder().file("car2.jpg").source("car2.jpg").car(c10.getId()).build();
	    Carfile cf11 = Carfile.builder().file("car3.jpg").source("car3.jpg").car(c11.getId()).build();
	    Carfile cf12 = Carfile.builder().file("car4.jpg").source("car4.jpg").car(c12.getId()).build();
	    Carfile cf13 = Carfile.builder().file("gv81.jpg").source("gv81.jpg").car(c13.getId()).build();
	    Carfile cf14 = Carfile.builder().file("car2.jpg").source("car2.jpg").car(c14.getId()).build();
	    Carfile cf15 = Carfile.builder().file("car3.jpg").source("car3.jpg").car(c15.getId()).build();
	    Carfile cf16 = Carfile.builder().file("car4.jpg").source("car4.jpg").car(c16.getId()).build();
	    Carfile cf17 = Carfile.builder().file("k9.jpg").source("k9.jpg").car(c17.getId()).build();
	    Carfile cf18 = Carfile.builder().file("car2.jpg").source("car2.jpg").car(c18.getId()).build();
	    Carfile cf19 = Carfile.builder().file("car3.jpg").source("car3.jpg").car(c19.getId()).build();
	    Carfile cf20 = Carfile.builder().file("car4.jpg").source("car4.jpg").car(c20.getId()).build();
	    Carfile cf21 = Carfile.builder().file("k5.jpg").source("k5.jpg").car(c21.getId()).build();
	    Carfile cf22 = Carfile.builder().file("car2.jpg").source("car2.jpg").car(c22.getId()).build();
	    Carfile cf23 = Carfile.builder().file("car3.jpg").source("car3.jpg").car(c23.getId()).build();
	    Carfile cf24 = Carfile.builder().file("car4.jpg").source("car4.jpg").car(c24.getId()).build();
	    Carfile cf25 = Carfile.builder().file("mini.jpg").source("mini.jpg").car(c25.getId()).build();
	    Carfile cf26 = Carfile.builder().file("car2.jpg").source("car2.jpg").car(c26.getId()).build();
	    Carfile cf27 = Carfile.builder().file("car3.jpg").source("car3.jpg").car(c27.getId()).build();
	    Carfile cf28 = Carfile.builder().file("car4.jpg").source("car4.jpg").car(c28.getId()).build();
	    Carfile cf29 = Carfile.builder().file("so.jpg").source("so.jpg").car(c29.getId()).build();
	    Carfile cf30 = Carfile.builder().file("car2.jpg").source("car2.jpg").car(c30.getId()).build();
	    Carfile cf31 = Carfile.builder().file("car3.jpg").source("car3.jpg").car(c31.getId()).build();
	    Carfile cf32 = Carfile.builder().file("car4.jpg").source("car4.jpg").car(c32.getId()).build();
	    Carfile cf33 = Carfile.builder().file("cani.jpg").source("cani.jpg").car(c33.getId()).build();
	    Carfile cf34 = Carfile.builder().file("car2.jpg").source("car2.jpg").car(c34.getId()).build();
	    Carfile cf35 = Carfile.builder().file("car3.jpg").source("car3.jpg").car(c35.getId()).build();
	    Carfile cf36 = Carfile.builder().file("car4.jpg").source("car4.jpg").car(c36.getId()).build();
	    Carfile cf37 = Carfile.builder().file("st.jpg").source("st.jpg").car(c37.getId()).build();
	    Carfile cf38 = Carfile.builder().file("car2.jpg").source("car2.jpg").car(c38.getId()).build();
	    Carfile cf39 = Carfile.builder().file("car3.jpg").source("car3.jpg").car(c39.getId()).build();
	    Carfile cf40 = Carfile.builder().file("car4.jpg").source("car4.jpg").car(c40.getId()).build();
	    Carfile cf41 = Carfile.builder().file("do1.jpg").source("do1.jpg").car(c41.getId()).build();
	    Carfile cf42 = Carfile.builder().file("hon1.jpg").source("hon1.jpg").car(c42.getId()).build();
	    Carfile cf43 = Carfile.builder().file("nx1.jpg").source("nx1.jpg").car(c43.getId()).build();
	    Carfile cf44 = Carfile.builder().file("ls1.jpg").source("ls1.jpg").car(c44.getId()).build();
	    Carfile cf45 = Carfile.builder().file("do2.jpg").source("do2.jpg").car(c45.getId()).build();
	    Carfile cf46 = Carfile.builder().file("hon2.jpg").source("hon2.jpg").car(c46.getId()).build();
	    Carfile cf47 = Carfile.builder().file("nx2.jpg").source("nx2.jpg").car(c47.getId()).build();
	    Carfile cf48 = Carfile.builder().file("ls2.jpg").source("ls2.jpg").car(c48.getId()).build();
	    Carfile cf49 = Carfile.builder().file("ev1.jpg").source("ev1.jpg").car(c49.getId()).build();
	    Carfile cf50 = Carfile.builder().file("md1.jpg").source("md1.jpg").car(c50.getId()).build();
	    Carfile cf51 = Carfile.builder().file("xt1.jpg").source("xt1.jpg").car(c51.getId()).build();
	    Carfile cf52 = Carfile.builder().file("ring1.jpg").source("ring1.jpg").car(c52.getId()).build();
	    Carfile cf53 = Carfile.builder().file("ev2.jpg").source("ev2.jpg").car(c53.getId()).build();
	    Carfile cf54 = Carfile.builder().file("md2.jpg").source("md2.jpg").car(c54.getId()).build();
	    Carfile cf55 = Carfile.builder().file("xt2.jpg").source("xt2.jpg").car(c55.getId()).build();
	    Carfile cf56 = Carfile.builder().file("ring2.jpg").source("ring2.jpg").car(c56.getId()).build();
	    Carfile cf57 = Carfile.builder().file("ev3.jpg").source("ev3.jpg").car(c57.getId()).build();
	    Carfile cf58 = Carfile.builder().file("md3.jpg").source("md3.jpg").car(c58.getId()).build();
	    Carfile cf59 = Carfile.builder().file("xt3.jpg").source("xt3.jpg").car(c59.getId()).build();
	    Carfile cf60 = Carfile.builder().file("ring3.jpg").source("ring3.jpg").car(c60.getId()).build();
	    
	    cf1 = carfileRepository.save(cf1);    
	    cf2 = carfileRepository.save(cf2);    
	    cf3 = carfileRepository.save(cf3);    
	    cf4 = carfileRepository.save(cf4);   
	    cf5 = carfileRepository.save(cf5);    
	    cf6 = carfileRepository.save(cf6);    
	    cf7 = carfileRepository.save(cf7);    
	    cf8 = carfileRepository.save(cf8);
	    cf9 = carfileRepository.save(cf9);    
	    cf10 = carfileRepository.save(cf10);    
	    cf11 = carfileRepository.save(cf11);    
	    cf12 = carfileRepository.save(cf12);
	    cf13 = carfileRepository.save(cf13);
	    cf14 = carfileRepository.save(cf14);
	    cf15 = carfileRepository.save(cf15);
	    cf16 = carfileRepository.save(cf16);
	    cf17 = carfileRepository.save(cf17);
	    cf18 = carfileRepository.save(cf18);
	    cf19 = carfileRepository.save(cf19);
	    cf20 = carfileRepository.save(cf20);
	    cf21 = carfileRepository.save(cf21);      
	    cf22 = carfileRepository.save(cf22);
	    cf23 = carfileRepository.save(cf23);
	    cf24 = carfileRepository.save(cf24);
	    cf25 = carfileRepository.save(cf25);
	    cf26 = carfileRepository.save(cf26);
	    cf27 = carfileRepository.save(cf27);
	    cf28 = carfileRepository.save(cf28);
	    cf29 = carfileRepository.save(cf29);
	    cf30 = carfileRepository.save(cf30);
	    cf31 = carfileRepository.save(cf31);    
	    cf32 = carfileRepository.save(cf32);
	    cf33 = carfileRepository.save(cf33);
	    cf34 = carfileRepository.save(cf34);
	    cf35 = carfileRepository.save(cf35);
	    cf36 = carfileRepository.save(cf36);
	    cf37 = carfileRepository.save(cf37);
	    cf38 = carfileRepository.save(cf38);
	    cf39 = carfileRepository.save(cf39);
	    cf40 = carfileRepository.save(cf40);
	    cf41 = carfileRepository.save(cf41);      
	    cf42 = carfileRepository.save(cf42);
	    cf43 = carfileRepository.save(cf43);
	    cf44 = carfileRepository.save(cf44);
	    cf45 = carfileRepository.save(cf45);
	    cf46 = carfileRepository.save(cf46);
	    cf47 = carfileRepository.save(cf47);
	    cf48 = carfileRepository.save(cf48);
	    cf49 = carfileRepository.save(cf49);
	    cf50 = carfileRepository.save(cf50);
	    cf51 = carfileRepository.save(cf51);      
	    cf52 = carfileRepository.save(cf52);
	    cf53 = carfileRepository.save(cf53);
	    cf54 = carfileRepository.save(cf54);
	    cf55 = carfileRepository.save(cf55);
	    cf56 = carfileRepository.save(cf56);
	    cf57 = carfileRepository.save(cf57);
	    cf58 = carfileRepository.save(cf58);
	    cf59 = carfileRepository.save(cf59);
	    cf60 = carfileRepository.save(cf60);
	}

}
