package com.lec.spring.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lec.spring.domain.Authority;
import com.lec.spring.domain.User;
import com.lec.spring.domain.qna.Roomfile;
import com.lec.spring.domain.qna.Qcomment;
import com.lec.spring.domain.qna.Qna;
import com.lec.spring.repository.qna.QCommentRepository;
import com.lec.spring.repository.qna.QfileRepository;
import com.lec.spring.repository.qna.QnaRepository;

@SpringBootTest
class RepositoryTest {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private QnaRepository writeRepository;
	@Autowired
	private AuthorityRepository authorityRepository;
	@Autowired
	private QCommentRepository commentRepository;
	@Autowired
	private QfileRepository fileRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	void init() {
		System.out.println("[init]");
		
		// Authority 생성
		Authority auth_member = Authority.builder()
					.name("ROLE_MEMBER")
					.build();
		Authority auth_admin_air = Authority.builder()
				.name("ROLE_ADMIN_AIR")
				.build();
		Authority auth_admin_hotel = Authority.builder()
				.name("ROLE_ADMIN_HOTEL")
				.build();
		Authority auth_admin_rental = Authority.builder()
				.name("ROLE_ADMIN_RENTAL")
				.build();
		Authority auth_admin_shop = Authority.builder()
				.name("ROLE_ADMIN_SHOP")
				.build();
		Authority auth_admin_qna = Authority.builder()
				.name("ROLE_ADMIN_QNA")
				.build();
		
		auth_member = authorityRepository.saveAndFlush(auth_member);
		auth_admin_qna = authorityRepository.saveAndFlush(auth_admin_qna);
		auth_admin_air = authorityRepository.saveAndFlush(auth_admin_air);
		auth_admin_hotel = authorityRepository.saveAndFlush(auth_admin_hotel);
		auth_admin_rental = authorityRepository.saveAndFlush(auth_admin_rental);
		auth_admin_shop = authorityRepository.saveAndFlush(auth_admin_shop);
		
		authorityRepository.findAll().forEach(System.out::println);

		// User 생성
		User user1 = User.builder()
				.username("USER1")
//				.password("1234")  // 나중에 Security 적용하면 PasswordEncoder사용해야함.
				.password(passwordEncoder.encode("1234"))
				.name("회원1")
				.phonenum("01011111111")
				.email("111@gmail.com")
				.build();		
		User user2 = User.builder()
				.username("USER2")
				.password(passwordEncoder.encode("1234"))
				.name("회원2")
				.phonenum("01022222222")
				.email("222@gmail.com")
				.build();
		User adminqna = User.builder()
				.username("ADMINQNA")
				.password(passwordEncoder.encode("1234"))
				.name("관리자0")
				.phonenum("01033333333")
				.email("333@gmail.com")
				.build();
		User adminair = User.builder()
				.username("ADMINAIR")
				.password(passwordEncoder.encode("1234"))
				.name("관리자1")
				.phonenum("01044444444")
				.email("444@gmail.com")
				.build();
		User adminhotel = User.builder()
				.username("ADMINHOTEL")
				.password(passwordEncoder.encode("1234"))
				.name("관리자2")
				.phonenum("01055555555")
				.email("555@gmail.com")
				.build();
		User adminrental = User.builder()
				.username("ADMINRENTAL")
				.password(passwordEncoder.encode("1234"))
				.name("관리자3")
				.phonenum("01066666666")
				.email("666@gmail.com")
				.build();
		User adminshop = User.builder()
				.username("ADMINSHOP")
				.password(passwordEncoder.encode("1234"))
				.name("관리자4")
				.phonenum("01077777777")
				.email("777@gmail.com")
				.build();

		user1.addAuthority(auth_member);
		adminqna.addAuthority(auth_member, auth_admin_qna);
		adminair.addAuthority(auth_member, auth_admin_air);
		adminhotel.addAuthority(auth_member, auth_admin_hotel);
		adminrental.addAuthority(auth_member, auth_admin_rental);
		adminshop.addAuthority(auth_member, auth_admin_shop);
		
		user1 = userRepository.save(user1);
		user2 = userRepository.save(user2);
		adminqna = userRepository.save(adminqna);
		adminair = userRepository.save(adminair);
		adminhotel = userRepository.save(adminhotel);
		adminrental = userRepository.save(adminrental);
		adminshop = userRepository.save(adminshop);
		
		userRepository.findAll().forEach(System.out::println);

		// 글 Write 작성
		Qna w1 = Qna.builder()
				.subject("제목입니다1")
				.content("내용입니다1")
				.user(user1)
				.build();
		
		Qna w2 = Qna.builder()
				.subject("제목입니다2")
				.content("내용입니다2")
				.user(user1)
				.build();
		
		Qna w3 = Qna.builder()
				.subject("제목입니다3")
				.content("내용입니다3")
				.user(adminqna)
				.build();
		
		Qna w4 = Qna.builder()
				.subject("제목입니다4")
				.content("내용입니다4")
				.user(adminqna)
				.build();
		
		w1 = writeRepository.save(w1);
		w2 = writeRepository.save(w2);
		w3 = writeRepository.save(w3);
		w4 = writeRepository.save(w4);
		
		writeRepository.findAll().forEach(System.out::println);
		
		
		// 댓글 Comment
		Qcomment c9 = Qcomment.builder()
				.content("9. admin1이 1번글에 댓글 작성.")
				.user(adminqna)
				.write(w1.getId())
				.build();
		Qcomment c10 = Qcomment.builder()
				.content("10. admin1이 1번글에 댓글 작성.")
				.user(adminqna)
				.write(w1.getId())
				.build();
		Qcomment c11 = Qcomment.builder()
				.content("11. admin1이 2번글에 댓글 작성.")
				.user(adminqna)
				.write(w2.getId())
				.build();
		Qcomment c12 = Qcomment.builder()
				.content("12. admin1이 2번글에 댓글 작성.")
				.user(adminqna)
				.write(w2.getId())
				.build();
		Qcomment c13 = Qcomment.builder()
				.content("13. admin1이 3번글에 댓글 작성.")
				.user(adminqna)
				.write(w3.getId())
				.build();
		Qcomment c14 = Qcomment.builder()
				.content("14. admin1이 3번글에 댓글 작성.")
				.user(adminqna)
				.write(w3.getId())
				.build();
		Qcomment c15 = Qcomment.builder()
				.content("15. admin1이 4번글에 댓글 작성.")
				.user(adminqna)
				.write(w4.getId())
				.build();
		Qcomment c16 = Qcomment.builder()
				.content("16. admin1이 4번글에 댓글 작성.")
				.user(adminqna)
				.write(w4.getId())
				.build();
		
		
		
		c9 = commentRepository.save(c9);
		c10 = commentRepository.save(c10);
		c11 = commentRepository.save(c11);
		c12 = commentRepository.save(c12);
		c13 = commentRepository.save(c13);
		c14 = commentRepository.save(c14);
		c15 = commentRepository.save(c15);
		c16 = commentRepository.save(c16);

		commentRepository.findAll().forEach(System.out::println);

		// 첨부파일 
		Roomfile file1 = Roomfile.builder()
				.file("face01.png")
				.source("face01.png")
				.write(w1.getId())
				.build();
		Roomfile file2 = Roomfile.builder()
				.file("face02.png")
				.source("face02.png")
				.write(w1.getId())
				.build();
		Roomfile file3 = Roomfile.builder()
				.file("face03.png")
				.source("face03.png")
				.write(w2.getId())
				.build();
		Roomfile file4 = Roomfile.builder()
				.file("face04.png")
				.source("face04.png")
				.write(w2.getId())
				.build();
		Roomfile file5 = Roomfile.builder()
				.file("face05.png")
				.source("face05.png")
				.write(w3.getId())
				.build();
		Roomfile file6 = Roomfile.builder()
				.file("face06.png")
				.source("face06.png")
				.write(w3.getId())
				.build();
		Roomfile file7 = Roomfile.builder()
				.file("face07.png")
				.source("face07.png")
				.write(w4.getId())
				.build();
		Roomfile file8 = Roomfile.builder()
				.file("face08.png")
				.source("face08.png")
				.write(w4.getId())
				.build();
		
		file1 = fileRepository.save(file1);
		file2 = fileRepository.save(file2);
		file3 = fileRepository.save(file3);
		file4 = fileRepository.save(file4);		
		file5 = fileRepository.save(file5);
		file6 = fileRepository.save(file6);
		file7 = fileRepository.save(file7);
		file8 = fileRepository.save(file8);
		
		fileRepository.findAll().forEach(System.out::println);


		
	}
}
