package com.lec.spring.repository.hotel;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.hotel.Hcomment;

public interface HcommentRepository extends JpaRepository<Hcomment, Long> {

}
