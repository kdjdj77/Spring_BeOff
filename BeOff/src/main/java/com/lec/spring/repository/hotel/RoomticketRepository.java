package com.lec.spring.repository.hotel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.air.Airticket;
import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.domain.User;
import com.lec.spring.domain.hotel.Room;
import com.lec.spring.domain.hotel.Roomticket;

public interface RoomticketRepository extends JpaRepository<Roomticket, Long> {


	List<Roomticket> findByDateAndRoom(Long d, Room r);

	List<Roomticket> findByUser(User loggedUser);
	
	List<Roomticket> findByUserOrderByIdDesc(User user);

	List<Roomticket> findByRoom(Room r);

	
}