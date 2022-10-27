package com.lec.spring.service;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.User;
import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.domain.hotel.Room;
import com.lec.spring.domain.hotel.Roomfile;
import com.lec.spring.repository.AuthorityRepository;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.hotel.AdminHotelRepository;
import com.lec.spring.repository.hotel.HotelRepository;
import com.lec.spring.repository.hotel.RoomRepository;
import com.lec.spring.repository.hotel.RoomfileRepository;
import com.lec.spring.util.U;
import org.springframework.util.StringUtils;

@Service
public class AdminHotelService {
	
	@Autowired
	private AdminHotelRepository adminHotelRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthorityRepository authorityRepository;
	@Autowired
	private RegionRepository regionRepository;
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private RoomRepository roomRepository;
	
	// 파일첨부 테스트
	@Autowired
	private RoomfileRepository roomfileRepository;
	
	@Value("${app.upload.path}") // 스프링껄로 import 해야함. // 설정파일의 설정값 주입
	private String uploadDir;
	
	@Autowired
	ServletContext context; // ServletContext 도 주입받을 수 있다. 
	
	
	
	// 호텔 등록
	@Transactional
	public int registerHotel(String username, String hotelname, String region, String content) {
		Hotel h = new Hotel();
		h.setUser(userRepository.findByUsername(username));
		h.setHotelname(hotelname);
		h.setRegion(regionRepository.findByRegion(region));
		h.setContent(content);
		hotelRepository.saveAndFlush(h);
		return 1;
	}
	
	// 룸 등록 - 선택한 호텔에 대한 룸 등록.
	public int registerRoom(
			String id, String roomname, Double price, Long bed, Map<String, MultipartFile> files
			) {
	Room r = new Room();
	
	Long hotelId = Long.parseLong(id);
	
	Hotel h = adminHotelRepository.findById(hotelId).get();
	r.setHotel(h);
	r.setRoomname(roomname);
	r.setPrice(price);
	r.setBed(bed);
	roomRepository.saveAndFlush(r);
	
	addFiles(files, r.getId());
	
	return 1;
	}
	
	// 특정 글(id) 에 첨부파일 추가
	private int addFiles(Map<String, MultipartFile> files, Long id) {
		if(files == null) return 0;
		
		for(Map.Entry<String, MultipartFile> e : files.entrySet()) {
			// 첨부파일들 정보 출력
			System.out.println("\n첨부파일 정보 : " + e.getKey()); // name 값
			U.printFileInfo(e.getValue());
			System.out.println();
			
			// 물리적인 파일 업로드
			Roomfile file = upload(e.getValue());
			
			// 성공하면 DB에도 저장
			if(file != null) {
				file.setRoom(id); // FK
				file = roomfileRepository.save(file); // INSERT
			}
		}
		return 1;
	
	} // end addFiles()

	// 물리적으로 파일 저장. 중복된 이름 처리
	private Roomfile upload(MultipartFile multipartFile) {
		Roomfile attachment = null;

		// 담긴 파일이 없으면 pass~
		String originalFilename = multipartFile.getOriginalFilename();
		if(originalFilename == null || originalFilename.length() == 0) return null;
		
		// 원본 파일 명
        String sourceName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        // 저장될 파일 명
        String fileName = sourceName;
        
        // 파일명이 중복되는지 확인
        File file = new File(context.getRealPath(uploadDir) + File.separator + sourceName);
        if(file.exists()) {  // 중복된다면, 다른 이름으로 변경하여 파일 저장한다.
        	int pos = fileName.lastIndexOf(".");
        	if(pos > -1) { // 확장자가 있는 경우
	        	String name = fileName.substring(0, pos);  // 파일'이름' 
	        	String ext = fileName.substring(pos + 1);  // 파일'확장명' 
	        	
	        	// 중복방지를 위한 새로운 이름 (현재시간 ms) 를 파일명에 추가
	        	fileName = name + "_" + System.currentTimeMillis() + "." + ext;
        	} else {
        		fileName += "_" + System.currentTimeMillis();
        	}
        }
	
     // 저장할 피일명
        System.out.println("fileName: " + fileName);
        
		Path copyOfLocation = 
        		Paths.get(context.getRealPath(uploadDir) + File.separator + fileName);

        System.out.println(copyOfLocation);
        System.out.println("file name : "+fileName);
        
        try {
            // inputStream을 가져와서
            // copyOfLocation (저장위치)로 파일을 쓴다.
            // copy의 옵션은 기존에 존재하면 REPLACE(대체한다), 오버라이딩 한다
        	
        	// java.nio.file.Files
            Files.copy(
            		multipartFile.getInputStream(), 
            		copyOfLocation, 
            		StandardCopyOption.REPLACE_EXISTING   // 기존에 존재하면 덮어쓰기
            		);
        } catch (IOException e) {
            e.printStackTrace();
            // 예외처리는 여기서.
            //throw new FileStorageException("Could not store file : " + multipartFile.getOriginalFilename());
        }	
		
        attachment = Roomfile.builder()
        		.file(fileName) // 저장된 이름
        		.source(sourceName) // 원본이름
        		.build()
        		;
		
		return attachment;
	}
		
	// [이미지 파일 여부 세팅]
	public void setImage(List<Roomfile> fileList) {
		// upload 실제 물리적인 경로
		String realPath = context.getRealPath(uploadDir);
		
		for(Roomfile fileDto : fileList) {
			BufferedImage imgData = null;
			File f = new File(realPath, fileDto.getFile());  // 첨부파일에 대한 File 객체
			try {
				imgData = ImageIO.read(f);
				// ※ ↑ 파일이 존재 하지 않으면 IOExcepion 발생한다
				//   ↑ 이미지가 아닌 경우는 null 리턴
			} catch (IOException e) {
				System.out.println("파일존재안함: " + f.getAbsolutePath() + " [" + e.getMessage() + "]");
			}					
			
			if(imgData != null) fileDto.setImage(true); // 이미지 여부 체크
		} // end for
	}		
		
	// 지역 리스트 찾기
	@Transactional
	public List<String> getRegionList(){
		List<Region> list = regionRepository.findAll();	
		List<String> sList = new ArrayList<String>();
		
		for(Region line : list) {
			sList.add(line.getRegion());
		}
		
		System.out.println(sList);
		
		return sList;
	}

	// 로그인 한 관리자(adminhotel) "본인"이 등록한 모든 호텔 리스트 조회
	@Transactional
	public List<Hotel> getHotelList() {
		
		// 로그인한 유저정보
		User u = U.getLoggedUser();
		
		List<Double> pList = new ArrayList<Double>();
		
		List<Hotel> h = hotelRepository.findByUser(u);
		for(Hotel i : h) {
			pList.clear();
			for(Room j : i.getRooms()) {
				pList.add(j.getPrice());			
			}
			for(Double p : pList) {
				if(i.getPriceList() != null) {
					i.setPriceList(i.getPriceList()+" , "+Double.toString(p));					
				}else {
					i.setPriceList(Double.toString(p));
				}
			}
			System.out.println(i.getPriceList());
		}
		
		return h;
	}
	
	// 룸 리스트 id역순으로 가져오기
	@Transactional
	public List<Room> getRoomList() {
		List<Room> RoomList = null;
		RoomList = roomRepository.findAll(Sort.by(Order.asc("id")));
		return RoomList;
	}

	// 호텔의 id 값을 받아옴
	@Transactional
	public Hotel getHotelById(String id) {
		Long lId = Long.parseLong(id);
		Hotel h = hotelRepository.findById(lId).get();
		return h;
	}

	// 호텔 업데이트
	@Transactional
	public int updateHotel(String id, String hotelname, String region, String content) {

		int result = 0;
		
		Long lId = Long.parseLong(id);
		
		Hotel h = hotelRepository.findById(lId).get();
		Region r = regionRepository.findByRegion(region);
		
		h.setHotelname(hotelname);
		h.setRegion(r);
		h.setContent(content);
		h.setRooms(getRoomList());
		hotelRepository.save(h);
		
		result = 1;
		
		return result;
	}
	
	// 방 업데이트
//	@Transactional
//	public int updateRoom(String id, String roomname, Double price, Long bed, Map<String, MultipartFile> files) {
//		
//		int result = 0;
//		
//		Long lId = Long.parseLong(id);
//		Room r = roomRepository.findById(lId).get();
//
//		r.setRoomname(roomname);
//		r.setPrice(price);
//		r.setBed(bed);
//		
//		roomRepository.save(r);
//		
//		result = 1;
//		
//		return result;
//	}
	
	// 방 업데이트 2차테스트 중
	@Transactional
	public int updateRoom(
			String id, String roomname, Double price, Long bed, 
			Map<String, MultipartFile> files) {
		
		int result = 0;
		
		Long lId = Long.parseLong(id);
		Room r = roomRepository.findById(lId).get();

		r.setRoomname(roomname);
		r.setPrice(price);
		r.setBed(bed);
		
		roomRepository.save(r);
		List<Roomfile> delfile = roomfileRepository.findByRoom(r.getId());
		
		if (addFiles(files, r.getId()) == 1) {
				delFile(r.getFiles().get(0));
				roomfileRepository.delete(delfile.get(0));
		}

		result = 1;
		
		return result;
	}
		
	// 특정 첨부파일(id)을 물리적으로 삭제
	private void delFile(Roomfile file) {
		String saveDirectory = context.getRealPath(uploadDir);
		File f = new File(saveDirectory, file.getFile()); // 물리적으로 저장된 파일들이 삭제 대상
		System.out.println("삭제시도--> " + f.getAbsolutePath());

		if (f.exists()) {
			if (f.delete()) { // 삭제!
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		} // end if
	}
	
	
	// 호텔 삭제
	@Transactional
	public int deleteHotel(String id) {
		int result = 0;
		
		Long lId = Long.parseLong(id);
		
		Hotel h = hotelRepository.findById(lId).get();
		hotelRepository.delete(h);
		result = 1;
		
		return result;
	}
	
	// 룸 삭제
	@Transactional
	public int deleteRoom(String id) {
		int result = 0;
		
		Long lId = Long.parseLong(id);
		
		Room r = roomRepository.findById(lId).get();
		roomRepository.delete(r);
		delFile(r.getFiles().get(0));
		System.out.println("서비스에서 id "+id);
		result = 1;
		
		return result;
	}
}
