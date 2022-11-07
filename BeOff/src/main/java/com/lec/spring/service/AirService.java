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
	@Transactional
	public int rUpdate(String regionId, String updateregion) {
		Long id = Long.parseLong(regionId);
		Region r = regionRepository.findById(id).get();
		r.setRegion(updateregion);
		regionRepository.save(r);		
		return 1;
	}
	@Transactional
	public int tUpdate(String timeId, String updatetime) {
		Long id = Long.parseLong(timeId);
		Airtime t = airtimeRepository.findById(id).get();
		t.setTime(updatetime);
		airtimeRepository.save(t);		
		return 1;
	}

	public int nUpdate(String nameId, String updatename, Double updateprice) {
		Long id = Long.parseLong(nameId);
		Airname t = airnameRepository.findById(id).get();
		t.setName(updatename);
		t.setPrice(updateprice);
		airnameRepository.save(t);
		return 1;
	}

	public Region getRegionById(String region) {
		Long id = Long.parseLong(region);
		Region r = regionRepository.findById(id).get();
		return r;
	}

	public Airname getNameById(String aircomp) {
		Long id = Long.parseLong(aircomp);
		Airname n = airnameRepository.findById(id).get();
		return n;
	}

	public List<Airtime> findAirtimeExist(Region s, Region e, Airname n) {
		List<Airplane> airplanes = airplaneRepository.findByDepartAndArriveAndName(s, e, n);
		List<Airtime> airtimes = airtimeRepository.findAll();
		List<Airtime> times = new ArrayList<Airtime>();
		
		for (Airplane a : airplanes) {
			for (Airtime t : airtimes) {
				if (a.getTime().getId() == t.getId()) {
					if (!times.contains(t)) times.add(t);
				}
			}
		}
		return times;
	}
	@Transactional
	public int updateAirplaneTable(Region s, Region e, Airname n, List<String> etimeList) {
		List<Airplane> airplanes = airplaneRepository.findByDepartAndArriveAndName(s, e, n);
		List<String> airplaneTimes = new ArrayList<String>();
		List<Airplane> addAir = new ArrayList<Airplane>();
		List<Airplane> delAir = new ArrayList<Airplane>();
		for (Airplane a : airplanes) {
			if (!etimeList.contains(a.getTime().getTime())) delAir.add(a);
			else airplaneTimes.add(a.getTime().getTime());
		}
		for (String time : etimeList) {
			if(!airplaneTimes.contains(time)) {
				Airplane newAir = new Airplane();
				newAir.setDepart(s);
				newAir.setArrive(e);
				newAir.setName(n);
				newAir.setTime(airtimeRepository.findByTime(time));
				addAir.add(newAir);
			}
		}
		for (Airplane a : delAir) airplaneRepository.delete(a);
		for (Airplane a : addAir) airplaneRepository.saveAndFlush(a);
		
		
		return 1;
	}

	public List<Airticket> getMyTickets() {
		User user = U.getLoggedUser();
		List<Airticket> tickets = airticketRepository.findByUserOrderByIdDesc(user);
		List<Airticket> t = new ArrayList<Airticket>();
		Airticket a = new Airticket();
		
		for(Airticket i : tickets) {
			if (!a.getRegDateTime().equals(i.getRegDateTime()) || 
					a.getAirplane().getId() != i.getAirplane().getId() ||
					a.getDate() - i.getDate() != 0L) {
				t.add(a);
				a = i;
				a.setPrice(i.getAirplane().getName().getPrice());
				a.setIds(i.getId().toString());
			} else {
				a.setPrice(a.getPrice() + i.getAirplane().getName().getPrice());
				a.setSeat(a.getSeat() + ", " + i.getSeat());
				a.setIds(a.getIds() + ", " + i.getId());
			}
		}
		t.add(a);
		
		return t;
	}

	public int deleteTickets(String ids) {
		String[] list = ids.split(", ");
		List<Long> llist = new ArrayList<Long>();
		
		for(String a : list) llist.add(Long.parseLong(a));
		for(Long i : llist) airticketRepository.delete(airticketRepository.findById(i).orElse(null));
		
		return 1;
	}

} // end Service
