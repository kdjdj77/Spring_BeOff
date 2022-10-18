package com.lec.spring.repository.item;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.item.Itemticket;

public interface ItemticketRepository extends JpaRepository<Itemticket, Long> {

}
