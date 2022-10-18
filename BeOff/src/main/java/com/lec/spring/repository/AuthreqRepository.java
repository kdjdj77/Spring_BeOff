package com.lec.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.Authreq;

public interface AuthreqRepository extends JpaRepository<Authreq, Long> {

}
