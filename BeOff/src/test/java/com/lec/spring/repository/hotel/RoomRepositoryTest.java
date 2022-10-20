package com.lec.spring.repository.hotel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.User;
import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.domain.hotel.Room;
import com.lec.spring.domain.hotel.Roomfile;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;

@SpringBootTest
class RoomRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private RoomfileRepository roomfileRepository;
	@Autowired
	private RegionRepository regionRepository;
	
	@Test
	void test() {
		User adminhotel = userRepository.findByUsername("ADMINHOTEL");

		User user1 = userRepository.findByUsername("USER1");
		User user2 = userRepository.findByUsername("USER2");

		Region korea = regionRepository.findByRegion("한국");
		Region japan = regionRepository.findByRegion("일본");
		Region usa = regionRepository.findByRegion("미국");

		// 호텔 입력

		Hotel h1 = Hotel.builder().hotelname("시그니엘(서울)").content("국내 최고 호텔입니다").user(adminhotel).region(korea).avgstar(0).build();
		Hotel h2 = Hotel.builder().hotelname("포시즌스").content("널찍한 객실 공간에 고급스러움을 느낄 수 있습니다").user(adminhotel).region(korea).avgstar(0).build();
		Hotel h3 = Hotel.builder().hotelname("파라다이스시티").content("조식이 맛있습니다").user(adminhotel).region(korea).avgstar(0).build();
		Hotel h4 = Hotel.builder().hotelname("롯데호텔").content("위치와 전망이 좋습니다").user(adminhotel).region(korea).avgstar(0).build();
		Hotel h5 = Hotel.builder().hotelname("JW 메리어트").content("품격 있는 숙박을 원한다면 JW 메리어트를 선택하세요").user(adminhotel).region(korea).avgstar(0).build();
		Hotel h6 = Hotel.builder().hotelname("반얀트리").content("고급진 객실 객실이 있습니다.").user(adminhotel).region(korea).avgstar(0).build();
		Hotel h7 = Hotel.builder().hotelname("앰배서더").content("세련된 호텔입니다").user(adminhotel).region(korea).avgstar(0).build();
		Hotel h8 = Hotel.builder().hotelname("더 리츠칼튼").content("공항에서 거리가 가까워요").user(adminhotel).region(japan).avgstar(0).build();
		Hotel h9 = Hotel.builder().hotelname("뉴 오타니 도쿄").content("작은 폭포와 멋진 전망이 있습니다.").user(adminhotel).region(japan).avgstar(0).build();
		Hotel h10 = Hotel.builder().hotelname("만다린 오리엔탈").content("지하철 역과 가깝고 고급 레스토랑이 있습니다.").user(adminhotel).region(japan).avgstar(0).build();
		Hotel h11 = Hotel.builder().hotelname("아만 도쿄").content("위생, 서비스가 최고입니다.").user(adminhotel).region(japan).avgstar(0).build();
		Hotel h12 = Hotel.builder().hotelname("게이오 플라자 호텔").content("풍부한 아침 식사가 준비되어있습니다.").user(adminhotel).region(japan).avgstar(0).build();
		Hotel h13 = Hotel.builder().hotelname("류메이칸 오차노미즈").content("시티투어를 하기 편리한 관광명소에 있습니다.").user(adminhotel).region(japan).avgstar(0).build();
		Hotel h14 = Hotel.builder().hotelname("가조엔 도쿄").content("호텔의 첫인상은 굉장합니다.").user(adminhotel).region(japan).avgstar(0).build();
		Hotel h15 = Hotel.builder().hotelname("로우 NYC").content("4성급 호텔, 타임스퀘어가 근처에 있습니다").user(adminhotel).region(usa).avgstar(0).build();
		Hotel h16 = Hotel.builder().hotelname("그랜드 하얏트 뉴욕").content("뉴욕 관광명소들이 자리잡고 있습니다").user(adminhotel).region(usa).avgstar(0).build();
		Hotel h17 = Hotel.builder().hotelname("웰링턴").content("가성비가 좋습니다").user(adminhotel).region(usa).avgstar(0).build();
		Hotel h18 = Hotel.builder().hotelname("할레쿨라니").content("와이키키 해번의 아름다운 호텔").user(adminhotel).region(usa).avgstar(0).build();
		Hotel h19 = Hotel.builder().hotelname("카할라 호텔").content("고급진 숙박과 편안함을 가진 카할라 호텔").user(adminhotel).region(usa).avgstar(0).build();
		Hotel h20 = Hotel.builder().hotelname("벨라지오").content("미국 5성급 호텔").user(adminhotel).region(usa).avgstar(0).build();
		Hotel h21 = Hotel.builder().hotelname("윈 라스베가스").content("라스베가스 중심에 있는 호텔").user(adminhotel).region(usa).avgstar(0).build();

		h1 = hotelRepository.save(h1);
		h2 = hotelRepository.save(h2);
		h3 = hotelRepository.save(h3);
		h4 = hotelRepository.save(h4);
		h5 = hotelRepository.save(h5);
		h6 = hotelRepository.save(h6);
		h7 = hotelRepository.save(h7);
		h8 = hotelRepository.save(h8);
		h9 = hotelRepository.save(h9);
		h10 = hotelRepository.save(h10);
		h11 = hotelRepository.save(h11);
		h12 = hotelRepository.save(h12);
		h13 = hotelRepository.save(h13);
		h14 = hotelRepository.save(h14);
		h15 = hotelRepository.save(h15);
		h16 = hotelRepository.save(h16);
		h17 = hotelRepository.save(h17);
		h18 = hotelRepository.save(h18);
		h19 = hotelRepository.save(h19);
		h20 = hotelRepository.save(h20);
		h21 = hotelRepository.save(h21);

		hotelRepository.findAll().forEach(System.out::println);
		
		Room r1 = Room.builder().hotel(h1).roomname("스위트").price(27000).bed((long)3).build();
		Room r2 = Room.builder().hotel(h1).roomname("디럭스").price(150000).bed((long)2).build();
		Room r3 = Room.builder().hotel(h1).roomname("패밀리").price(320000).bed((long)1).build();
		Room r4 = Room.builder().hotel(h2).roomname("스위트").price(11000).bed((long)3).build();
		Room r5 = Room.builder().hotel(h2).roomname("디럭스").price(130000).bed((long)2).build();
		Room r6 = Room.builder().hotel(h2).roomname("패밀리").price(220000).bed((long)4).build();

		r1 = roomRepository.save(r1);
		r2 = roomRepository.save(r2);
		r3 = roomRepository.save(r3);
		r4 = roomRepository.save(r4);
		r5 = roomRepository.save(r5);
		r6 = roomRepository.save(r6);
		
		roomRepository.findAll().forEach(System.out::println);
		
		Roomfile rf1 = Roomfile.builder().file("room1.jpg").source("room1.jpg").room(r1.getId()).build();
		Roomfile rf2 = Roomfile.builder().file("room2.jpg").source("room2.jpg").room(r2.getId()).build();
		Roomfile rf3 = Roomfile.builder().file("room3.jpg").source("room3.jpg").room(r3.getId()).build();
		Roomfile rf4 = Roomfile.builder().file("room4.jpg").source("room4.jpg").room(r4.getId()).build();
		Roomfile rf5 = Roomfile.builder().file("room5.jpg").source("room5.jpg").room(r5.getId()).build();
		Roomfile rf6 = Roomfile.builder().file("room6.jpg").source("room6.jpg").room(r6.getId()).build();
		
		rf1 = roomfileRepository.save(rf1);
		rf2 = roomfileRepository.save(rf2);
		rf3 = roomfileRepository.save(rf3);
		rf4 = roomfileRepository.save(rf4);
		rf5 = roomfileRepository.save(rf5);
		rf6 = roomfileRepository.save(rf6);
		
		roomfileRepository.findAll().forEach(System.out::println);
	}

}
