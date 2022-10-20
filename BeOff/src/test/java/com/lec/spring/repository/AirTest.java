package com.lec.spring.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.User;
import com.lec.spring.domain.air.Airname;
import com.lec.spring.domain.air.Airplane;
import com.lec.spring.domain.air.Airticket;
import com.lec.spring.domain.air.Airtime;
import com.lec.spring.repository.air.AirnameRepository;
import com.lec.spring.repository.air.AirplaneRepository;
import com.lec.spring.repository.air.AirticketRepository;
import com.lec.spring.repository.air.AirtimeRepository;

@SpringBootTest
public class AirTest {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RegionRepository regionRepository;
	@Autowired
	private AirtimeRepository airtimeRepository;
	@Autowired
	private AirnameRepository airnameRepository;
	@Autowired
	private AirplaneRepository airplaneRepository;
	@Autowired
	private AirticketRepository airticketRepository;
	
	@Test
	void init() {
		Region korea = regionRepository.findByRegion("한국");
		Region japan = regionRepository.findByRegion("일본");
		Region usa = regionRepository.findByRegion("미국");
		
		Airname asiana = Airname.builder()
				.name("아시아나항공").price(510000).build();
		Airname daehan = Airname.builder()
				.name("대한항공").price(420000).build();
		Airname jinair = Airname.builder()
				.name("진에어항공").price(310000).build();
		asiana = airnameRepository.saveAndFlush(asiana);
		daehan = airnameRepository.saveAndFlush(daehan);
		jinair = airnameRepository.saveAndFlush(jinair);
		List<Airname> airN = new ArrayList<Airname>();
		airN.add(asiana);airN.add(daehan);airN.add(jinair);
		
		Airtime t0800 = Airtime.builder().time("08:00").build();
		Airtime t1000 = Airtime.builder().time("10:00").build();
		Airtime t1200 = Airtime.builder().time("12:00").build();
		Airtime t1400 = Airtime.builder().time("14:00").build();
		Airtime t1600 = Airtime.builder().time("16:00").build();
		Airtime t1800 = Airtime.builder().time("18:00").build();
		Airtime t2000 = Airtime.builder().time("20:00").build();
		Airtime t2200 = Airtime.builder().time("22:00").build();
		t0800 = airtimeRepository.saveAndFlush(t0800);
		t1000 = airtimeRepository.saveAndFlush(t1000);
		t1200 = airtimeRepository.saveAndFlush(t1200);
		t1400 = airtimeRepository.saveAndFlush(t1400);
		t1600 = airtimeRepository.saveAndFlush(t1600);
		t1800 = airtimeRepository.saveAndFlush(t1800);
		t2000 = airtimeRepository.saveAndFlush(t2000);
		t2200 = airtimeRepository.saveAndFlush(t2200);
		
		List<Airtime> airT = new ArrayList<Airtime>();
		airT.add(t0800);airT.add(t1000);airT.add(t1200);airT.add(t1400);
		airT.add(t1600);airT.add(t1800);airT.add(t2000);airT.add(t2200);
		
		setAir(korea, japan, airT, airN); // setticket 포함 (20221212, 20221213)
		setAir(korea, usa, airT, airN); // setticket 포함 (20221212, 20221213)
		setAir(japan, usa, airT, airN); // setticket 포함 (20221212, 20221213)
		
	}

	void setAir(Region S, Region E, List<Airtime> T, List<Airname> N) {
		User user1 = userRepository.findByUsername("USER1");
		for (Airtime t : T) {
			for (Airname n : N) {
				Airplane A = Airplane.builder()
						.depart(S).arrive(E).time(t).name(n).build();
				Airplane B = Airplane.builder()
						.depart(E).arrive(S).time(t).name(n).build();
				A = airplaneRepository.saveAndFlush(A);
				B = airplaneRepository.saveAndFlush(B);
				
				Airticket AT1 = Airticket.builder()
						.user(user1).airplane(A).seat("E04").date(20221212L).build();
				Airticket AT2 = Airticket.builder()
						.user(user1).airplane(B).seat("E04").date(20221213L).build();
				Airticket AT3 = Airticket.builder()
						.user(user1).airplane(A).seat("E05").date(20221212L).build();
				Airticket AT4 = Airticket.builder()
						.user(user1).airplane(B).seat("E05").date(20221213L).build();
				Airticket AT5 = Airticket.builder()
						.user(user1).airplane(A).seat("E06").date(20221212L).build();
				Airticket AT6 = Airticket.builder()
						.user(user1).airplane(B).seat("E06").date(20221213L).build();
				AT1 = airticketRepository.saveAndFlush(AT1);
				AT2 = airticketRepository.saveAndFlush(AT2);
				AT3 = airticketRepository.saveAndFlush(AT3);
				AT4 = airticketRepository.saveAndFlush(AT4);
				AT5 = airticketRepository.saveAndFlush(AT5);
				AT6 = airticketRepository.saveAndFlush(AT6);
			}
		}
	}
}
