package com.lec.spring.repository.item;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.item.Icomment;

public interface IcommentRepository extends JpaRepository<Icomment, Long> {

}
