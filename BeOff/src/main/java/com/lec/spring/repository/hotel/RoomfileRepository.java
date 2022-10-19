package com.lec.spring.repository.hotel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.hotel.Roomfile;

public interface RoomfileRepository extends JpaRepository<Roomfile, Long> {
	// 특정 room 의 첨부파일들
	List<Roomfile> findByWrite(Long roomId);
}
