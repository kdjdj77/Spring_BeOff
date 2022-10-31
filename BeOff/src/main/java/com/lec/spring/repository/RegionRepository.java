package com.lec.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
	Region findByRegion(String region);

	List<Region> findAll();
}
