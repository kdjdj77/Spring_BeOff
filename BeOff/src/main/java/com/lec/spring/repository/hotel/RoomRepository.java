package com.lec.spring.repository.hotel;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.hotel.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{

}
