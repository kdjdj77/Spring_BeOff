package com.lec.spring.repository.rental;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.rental.Carfile;

public interface CarfileRepository extends JpaRepository<Carfile, Long> {

}
