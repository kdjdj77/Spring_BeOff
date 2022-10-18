package com.lec.spring.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lec.spring.domain.Region;

@SpringBootTest
public class RegionTest {
	@Autowired
	private RegionRepository regionRepository;
	
	@Test
	void init() {
		Region region1 = Region.builder()
				.region("한국")
				.build()
				;
		Region region2 = Region.builder()
				.region("미국")
				.build()
				;
		Region region3 = Region.builder()
				.region("일본")
				.build()
				;
		region1 = regionRepository.saveAndFlush(region1);
		region2 = regionRepository.saveAndFlush(region2);
		region3 = regionRepository.saveAndFlush(region3);
	}
}
