package com.lec.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lec.spring.domain.qna.QqryCommentList;
import com.lec.spring.domain.qna.QqryResult;
import com.lec.spring.service.CommentService;

@RestController
@RequestMapping("/comment")
public class QCommentController {
	@Autowired
	private CommentService commentService;
	
	public QCommentController() {
		System.out.println(getClass().getName() + "() 생성");
	}
	
	@GetMapping("/list")
	public QqryCommentList list(Long id) {   // 특정글(id) 의 댓글목록들
		return commentService.list(id);
	}
	
	@PostMapping("/write")
	public QqryResult write(
			@RequestParam("write_id") Long writeId, 
			@RequestParam("user_id") Long userId, 
			String content) {
		
		return commentService.write(writeId, userId, content);
	}
	
	@PostMapping("/delete")
	public QqryResult delete(Long id) {
		return commentService.delete(id);
	}
}
