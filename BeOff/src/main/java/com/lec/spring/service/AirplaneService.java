package com.lec.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.air.AirDTO;
import com.lec.spring.domain.air.Airplane;
import com.lec.spring.domain.air.Airticket;
import com.lec.spring.domain.air.Airtime;
import com.lec.spring.domain.air.AqryList;
import com.lec.spring.domain.qna.Qcomment;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.air.AirplaneRepository;
import com.lec.spring.repository.air.AirticketRepository;
import com.lec.spring.repository.air.AirtimeRepository;

@Service	
public class AirplaneService {

	@Autowired
	ServletContext context;   // ServletContext 도 주입받을수 있다.
	
	@Autowired
	private AirplaneRepository airplaneRepository;
	@Autowired
	private AirticketRepository airticketRepository;
	@Autowired
	private AirtimeRepository airtimeRepository;
	@Autowired
	private RegionRepository regionRepository;

	public AirplaneService() {
		System.out.println(getClass().getName() + "() 생성");
	}	
	
	@Transactional
	public AqryList search(
			String departregion, String arriveregion, String time, String num_person, Long date) {
		AqryList list = new AqryList();
		List<Airplane> airplanes = null;
		List<AirDTO> airdto = new ArrayList<AirDTO>();
		
		Region dr = regionRepository.findByRegion(departregion);
		Region ar = regionRepository.findByRegion(arriveregion);
		Airtime t = airtimeRepository.findByTime(time);
		
		// 특정 글의 댓글들을 id역순으로 comments에 저장
		airplanes = airplaneRepository.findByDepartAndArriveAndTime(dr, ar, t);
		for(Airplane a : airplanes) {
			
			AirDTO dto = new AirDTO();
			
			dto.setRemain(135 - (airticketRepository.findByAirplaneAndDate(a, date)).size());
			dto.setDate(Long.toString(date));
			dto.setPrice(a.getName().getPrice());
			dto.setName(a.getName().getName());
			dto.setTime(a.getTime().getTime());
			dto.setDepart(a.getDepart().getRegion());
			dto.setArrive(a.getArrive().getRegion());
			
			if (dto.getRemain() >= Integer.parseInt(num_person)) airdto.add(dto);
			
		}
		
		list.setCount(airdto.size());
		list.setList(airdto);		
		list.setStatus("OK");
		return list;
	}
} // end Service
