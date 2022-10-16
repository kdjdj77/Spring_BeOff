package com.lec.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.lec.spring.domain.User;
import com.lec.spring.domain.qna.Qcomment;
import com.lec.spring.domain.qna.QqryCommentList;
import com.lec.spring.domain.qna.QqryResult;
import com.lec.spring.repository.QCommentRepository;
import com.lec.spring.repository.UserRepository;

@Service
public class CommentService {
	@Autowired
	private QCommentRepository commentRepository;
	@Autowired
	private UserRepository userRepository;
	
	public CommentService() {
		System.out.println(getClass().getName() + "() 생성");
	}
	
	// 특정 글(id)의 댓글 목록들
	public QqryCommentList list(Long id) {
		QqryCommentList list = new QqryCommentList();
		List<Qcomment> comments = null;
		
		// 특정 글의 댓글들을 id역순으로 comments에 저장
		comments = commentRepository.findByWrite(id, Sort.by(Order.desc("id")));
		
		list.setCount(comments.size());
		list.setList(comments);		
		list.setStatus("OK");
		return list;
	}
	
	// 특정 글(writeId)에 특정 사용자(UserId)가 댓글 작성
	public QqryResult write(Long writeId, Long userId, String content) {
		User user = userRepository.findById(userId).orElse(null);
		
		Qcomment comment = Qcomment.builder()
				.user(user)
				.content(content)
				.write(writeId)
				.build()
				;
		commentRepository.save(comment); // INSERT
		QqryResult result = QqryResult.builder()
				.count(1)
				.status("OK")
				.build()
				;
		return result;
	}
	
	// 특정 댓글(id) 삭제
	public QqryResult delete(Long id) {
		Qcomment comment = commentRepository.findById(id).orElse(null);
		
		int count = 0;
		String status = "FAIL";
		if (comment != null) {
			commentRepository.delete(comment);
			count = 1;
			status = "OK";
		}
		QqryResult result = QqryResult.builder()
				.count(count)
				.status(status)
				.build()
				;
		return result;
	}
}
