package com.lec.spring.repository.qna;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.qna.Qna;

public interface QnaRepository extends JpaRepository<Qna, Long> {

}
