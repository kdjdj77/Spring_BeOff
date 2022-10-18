package com.lec.spring.repository.hotel;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.hotel.Roomticket;

public interface RoomticketRepository extends JpaRepository<Roomticket, Long> {

}
