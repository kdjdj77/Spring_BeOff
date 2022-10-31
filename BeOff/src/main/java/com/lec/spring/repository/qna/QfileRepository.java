package com.lec.spring.repository.qna;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.qna.Qnafile;

public interface QfileRepository extends JpaRepository<Qnafile, Long> {
	// 특정 글(writeId)의 첨부파일들
	List<Qnafile> findByWrite(Long writeId);
}
