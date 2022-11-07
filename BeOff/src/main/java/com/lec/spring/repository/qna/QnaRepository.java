package com.lec.spring.repository.qna;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.qna.Qna;

public interface QnaRepository extends JpaRepository<Qna, Long> {

	Page<Qna> findBySubjectContaining(String search, PageRequest of);

}
