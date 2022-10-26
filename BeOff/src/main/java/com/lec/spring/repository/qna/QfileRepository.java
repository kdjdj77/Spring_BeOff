package com.lec.spring.repository.qna;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.qna.Roomfile;

public interface QfileRepository extends JpaRepository<Roomfile, Long> {
	// 특정 글(writeId)의 첨부파일들
	List<Roomfile> findByWrite(Long writeId);
}
