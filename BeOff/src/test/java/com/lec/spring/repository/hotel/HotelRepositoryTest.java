package com.lec.spring.repository.hotel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.User;
import com.lec.spring.domain.hotel.Hcomment;
import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;

@SpringBootTest
class HotelRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private HotelRepository hotelRepository;
//	@Autowired
//	private RoomRepository roomRepository;
	@Autowired
	private RegionRepository regionRepository;
	@Autowired
	private HcommentRepository hcommentRepository;

	@Test
	void init() {

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

		// 댓글

		Hcomment c1 = Hcomment.builder().hotel(h1).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c2 = Hcomment.builder().hotel(h1).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c3 = Hcomment.builder().hotel(h1).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c4 = Hcomment.builder().hotel(h2).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c5 = Hcomment.builder().hotel(h2).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c6 = Hcomment.builder().hotel(h2).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c7 = Hcomment.builder().hotel(h3).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c8 = Hcomment.builder().hotel(h3).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c9 = Hcomment.builder().hotel(h3).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c10 = Hcomment.builder().hotel(h5).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c11 = Hcomment.builder().hotel(h4).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c12 = Hcomment.builder().hotel(h4).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c13 = Hcomment.builder().hotel(h5).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c14 = Hcomment.builder().hotel(h5).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c15 = Hcomment.builder().hotel(h5).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c16 = Hcomment.builder().hotel(h6).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c17 = Hcomment.builder().hotel(h6).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c18 = Hcomment.builder().hotel(h6).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c19 = Hcomment.builder().hotel(h7).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c20 = Hcomment.builder().hotel(h7).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c21 = Hcomment.builder().hotel(h7).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c22 = Hcomment.builder().hotel(h8).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c23 = Hcomment.builder().hotel(h8).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c24 = Hcomment.builder().hotel(h8).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c25 = Hcomment.builder().hotel(h9).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c26 = Hcomment.builder().hotel(h9).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c27 = Hcomment.builder().hotel(h9).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c28 = Hcomment.builder().hotel(h10).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c29 = Hcomment.builder().hotel(h10).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c30 = Hcomment.builder().hotel(h10).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c31 = Hcomment.builder().hotel(h11).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c32 = Hcomment.builder().hotel(h11).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c33 = Hcomment.builder().hotel(h11).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c34 = Hcomment.builder().hotel(h12).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c35 = Hcomment.builder().hotel(h12).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c36 = Hcomment.builder().hotel(h12).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c37 = Hcomment.builder().hotel(h13).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c38 = Hcomment.builder().hotel(h13).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c39 = Hcomment.builder().hotel(h13).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c40 = Hcomment.builder().hotel(h14).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c41 = Hcomment.builder().hotel(h14).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c42 = Hcomment.builder().hotel(h14).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c43 = Hcomment.builder().hotel(h15).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c44 = Hcomment.builder().hotel(h15).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c45 = Hcomment.builder().hotel(h15).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c46 = Hcomment.builder().hotel(h16).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c47 = Hcomment.builder().hotel(h16).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c48 = Hcomment.builder().hotel(h16).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c49 = Hcomment.builder().hotel(h17).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c50 = Hcomment.builder().hotel(h17).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c51 = Hcomment.builder().hotel(h17).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c52 = Hcomment.builder().hotel(h18).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c53 = Hcomment.builder().hotel(h18).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c54 = Hcomment.builder().hotel(h18).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c55 = Hcomment.builder().hotel(h19).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c56 = Hcomment.builder().hotel(h19).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c57 = Hcomment.builder().hotel(h19).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c58 = Hcomment.builder().hotel(h20).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c59 = Hcomment.builder().hotel(h20).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c60 = Hcomment.builder().hotel(h20).user(user2).content("별로에요").star((long) 2).build();
		Hcomment c61 = Hcomment.builder().hotel(h21).user(adminhotel).content("안녕하세요").star((long) 4).build();
		Hcomment c62 = Hcomment.builder().hotel(h21).user(user1).content("좋습니다").star((long) 5).build();
		Hcomment c63 = Hcomment.builder().hotel(h21).user(user2).content("별로에요").star((long) 2).build();

		c1 = hcommentRepository.save(c1);
		c2 = hcommentRepository.save(c2);
		c3 = hcommentRepository.save(c3);
		c4 = hcommentRepository.save(c4);
		c5 = hcommentRepository.save(c5);
		c6 = hcommentRepository.save(c6);
		c7 = hcommentRepository.save(c7);
		c8 = hcommentRepository.save(c8);
		c9 = hcommentRepository.save(c9);
		c10 = hcommentRepository.save(c10);
		c11 = hcommentRepository.save(c11);
		c12 = hcommentRepository.save(c12);
		c13 = hcommentRepository.save(c13);
		c14 = hcommentRepository.save(c14);
		c15 = hcommentRepository.save(c15);
		c16 = hcommentRepository.save(c16);
		c17 = hcommentRepository.save(c17);
		c18 = hcommentRepository.save(c18);
		c19 = hcommentRepository.save(c19);
		c20 = hcommentRepository.save(c20);
		c21 = hcommentRepository.save(c21);
		c22 = hcommentRepository.save(c22);
		c23 = hcommentRepository.save(c23);
		c24 = hcommentRepository.save(c24);
		c25 = hcommentRepository.save(c25);
		c26 = hcommentRepository.save(c26);
		c27 = hcommentRepository.save(c27);
		c28 = hcommentRepository.save(c28);
		c29 = hcommentRepository.save(c29);
		c30 = hcommentRepository.save(c30);
		c31 = hcommentRepository.save(c31);
		c32 = hcommentRepository.save(c32);
		c33 = hcommentRepository.save(c33);
		c34 = hcommentRepository.save(c34);
		c35 = hcommentRepository.save(c35);
		c36 = hcommentRepository.save(c36);
		c37 = hcommentRepository.save(c37);
		c38 = hcommentRepository.save(c38);
		c39 = hcommentRepository.save(c39);
		c40 = hcommentRepository.save(c40);
		c41 = hcommentRepository.save(c41);
		c42 = hcommentRepository.save(c42);
		c43 = hcommentRepository.save(c43);
		c44 = hcommentRepository.save(c44);
		c45 = hcommentRepository.save(c45);
		c46 = hcommentRepository.save(c46);
		c47 = hcommentRepository.save(c47);
		c48 = hcommentRepository.save(c48);
		c49 = hcommentRepository.save(c49);
		c50 = hcommentRepository.save(c50);
		c51 = hcommentRepository.save(c51);
		c52 = hcommentRepository.save(c52);
		c53 = hcommentRepository.save(c53);
		c54 = hcommentRepository.save(c54);
		c55 = hcommentRepository.save(c55);
		c56 = hcommentRepository.save(c56);
		c57 = hcommentRepository.save(c57);
		c58 = hcommentRepository.save(c58);
		c59 = hcommentRepository.save(c59);
		c60 = hcommentRepository.save(c60);
		c61 = hcommentRepository.save(c61);
		c62 = hcommentRepository.save(c62);
		c63 = hcommentRepository.save(c63);

		hcommentRepository.findAll().forEach(System.out::println);
	}

}
