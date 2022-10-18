package com.lec.spring.repository.qna;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.qna.Qcomment;

public interface QCommentRepository extends JpaRepository<Qcomment, Long> {
	List<Qcomment> findByWrite(Long write, Sort sort);
}
