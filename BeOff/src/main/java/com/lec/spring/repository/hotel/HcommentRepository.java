package com.lec.spring.repository.hotel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.hotel.Hcomment;
import com.lec.spring.domain.hotel.Room;

public interface HcommentRepository extends JpaRepository<Hcomment, Long> {
	List<Hcomment> findAll();
}
