package com.lec.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.User;
import com.lec.spring.domain.air.Airname;
import com.lec.spring.domain.air.Airplane;
import com.lec.spring.domain.air.Airticket;
import com.lec.spring.domain.air.Airtime;
import com.lec.spring.domain.air.AqryList;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.air.AirnameRepository;
import com.lec.spring.repository.air.AirplaneRepository;
import com.lec.spring.repository.air.AirticketRepository;
import com.lec.spring.repository.air.AirtimeRepository;
import com.lec.spring.util.U;

@Service	
public class AirService {

	@Autowired
	ServletContext context;   // ServletContext 도 주입받을수 있다.
	
	@Autowired
	private AirplaneRepository airplaneRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AirtimeRepository airtimeRepository;
	@Autowired
	private RegionRepository regionRepository;
	@Autowired
	private AirticketRepository airticketRepository;
	@Autowired
	private AirnameRepository airnameRepository;

	public AirService() {
		System.out.println(getClass().getName() + "() 생성");
	}	
	
	@Transactional
	public List<String> getRegionList() {
		List<String> rNameList = new ArrayList<String>();
		List<Region> regionList = regionRepository.findAll();
		for (Region i : regionList) {
			rNameList.add(i.getRegion());
		}
		return rNameList;
	}
	@Transactional
	public List<String> getAirTimeList() {
		List<String> rTimeList = new ArrayList<String>();
		List<Airtime> airtimeList = airtimeRepository.findAll();
		for (Airtime i : airtimeList) {
			rTimeList.add(i.getTime());
		}
		return rTimeList;
	}
	
	@Transactional
	public AqryList search(
			String departregion, String arriveregion, String time, String num_person, Long date) {
		AqryList list = new AqryList();
		List<Airplane> airplanes = null;
		
		Region dr = regionRepository.findByRegion(departregion);
		Region ar = regionRepository.findByRegion(arriveregion);
		Airtime t = airtimeRepository.findByTime(time);
		
		// 특정 글의 댓글들을 id역순으로 comments에 저장
		airplanes = airplaneRepository.findByDepartAndArriveAndTime(dr, ar, t);
		List<Airplane> delAir = new ArrayList<Airplane>();
		for(Airplane a : airplanes) {
			
			a.setRemain(135 - (airticketRepository.findByAirplaneAndDate(a, date)).size());
			a.setDate(Long.toString(date));
			
			if (a.getRemain() < Integer.parseInt(num_person)) delAir.add(a);
		}
		for(Airplane i : delAir) { airplanes.remove(i); }
		
		list.setCount(airplanes.size());
		list.setList(airplanes);		
		list.setStatus("OK");
		return list;
	}
	@Transactional
	public List<String> getTicketSeatList(Long airId, Long date) {
		List<String> list = new ArrayList<String>();
		Airplane airplane = airplaneRepository.findById(airId).get();
		List<Airticket> tickets = airticketRepository.findByAirplaneAndDate(airplane, date);
		for(Airticket a : tickets) {
			list.add(a.getSeat());
		}
		return list;
	}

	public Airplane getAirplaneById(Long air_id) {
		Airplane air = airplaneRepository.findById(air_id).get();
		return air;
	}
	@Transactional
	public int registerSeats(List<String> seatList, String id, String departDate) {
		Long lid = Long.parseLong(id);
		Long dDate = Long.parseLong(departDate);
		
		User user = U.getLoggedUser();
		Airplane airplane = airplaneRepository.findById(lid).get();
		
		int cnt = 0;
		
		for(String i : seatList) {
			Airticket ticket = new Airticket();
			ticket.setUser(user);
			ticket.setAirplane(airplane);
			ticket.setDate(dDate);
			ticket.setSeat(i);
			airticketRepository.saveAndFlush(ticket);
			cnt++;
		}
		if (cnt == seatList.size()) return 1;
		else return 0;
	}
	@Transactional
	public List<Region> getRegions() {
		List<Region> regionList = regionRepository.findAll();
		return regionList;		
	}
	@Transactional
	public List<Airtime> getAirTimes() {
		List<Airtime> airTimeList = airtimeRepository.findAll();
		return airTimeList;		
	}
	@Transactional
	public List<Airname> getAirNames() {
		List<Airname> airNameList = airnameRepository.findAll();
		return airNameList;
	}
	@Transactional
	public int addregion(String addregion) {
		for(Region i : getRegions()) {
			if (addregion.equals(i.getRegion())) return 0;
		}
		Region r = new Region();
		r.setRegion(addregion);
		regionRepository.saveAndFlush(r);
		return 1;
	}
	@Transactional
	public int addtime(String addtime) {
		for(Airtime i : getAirTimes()) {
			if (addtime.equals(i.getTime())) return 0;
		}
		Airtime t = new Airtime();
		t.setTime(addtime);
		airtimeRepository.saveAndFlush(t);
		return 1;
	}
	@Transactional
	public int addname(String addname, Double addprice) {
		for(Airname i : getAirNames()) {
			if (addname.equals(i.getName())) return 0;
		}
		Airname n = new Airname();
		n.setName(addname);
		n.setPrice(addprice);
		airnameRepository.saveAndFlush(n);
		return 1;
	}
	@Transactional
	public int delRegionById(String region) {
		Region r = regionRepository.findById(Long.parseLong(region)).get();
		regionRepository.delete(r);
		return 1;
	}
	@Transactional
	public int delTimeById(String time) {
		Airtime t = airtimeRepository.findById(Long.parseLong(time)).get();
		airtimeRepository.delete(t);
		return 1;
	}
	@Transactional
	public int delNameById(String name) {
		Airname n = airnameRepository.findById(Long.parseLong(name)).get();
		airnameRepository.delete(n);
		return 1;
	}

} // end Service
