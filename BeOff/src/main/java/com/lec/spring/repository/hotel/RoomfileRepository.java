package com.lec.spring.repository.hotel;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.hotel.Roomfile;

public interface RoomfileRepository extends JpaRepository<Roomfile, Long> {

}
