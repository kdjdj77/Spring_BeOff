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
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.User;
import com.lec.spring.domain.rental.Car;
import com.lec.spring.domain.rental.Carfile;
import com.lec.spring.domain.rental.Rental;
import com.lec.spring.repository.AuthorityRepository;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.rental.AdminRentalRepository;
import com.lec.spring.repository.rental.CarRepository;
import com.lec.spring.repository.rental.CarfileRepository;
import com.lec.spring.repository.rental.RentalRepository;
import com.lec.spring.util.U;

@Service
public class AdminRentalService {

	@Autowired
	private AdminRentalRepository adminRentalRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private RegionRepository regionRepository;
	
	@Autowired
	private RentalRepository rentalRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private CarfileRepository carfileRepository;
	
	@Value("${app.upload.path}")
	private String uploadDir;
	
	@Autowired
	ServletContext context;
	
	// 지역 업체 리스트
	@Transactional
	public List<String> getRegionList() {
		List<Region> list = regionRepository.findAll();
		List<String> sList = new ArrayList<>();
		
		for(Region line : list) {
			sList.add(line.getRegion());
		}
		
		System.out.println(sList);
		
		return sList;
	}

	@Transactional
	public List<Rental> getRentalList() {
		User u = U.getLoggedUser();
		
		List<Float> adList = new ArrayList<>();
		
		List<Rental> rental = rentalRepository.findByUser(u);
		for(Rental r : rental) {
			adList.clear();
			for(Car c : r.getCars()) {
				adList.add(c.getPrice());
			}
		}
		return rental;
	}

	@Transactional
	public List<Car> getCarList() {
		List<Car> carList = null;
		carList = carRepository.findAll(Sort.by(Order.asc("id")));
		return carList;
	}

	@Transactional
	public Rental getRentalById(String id) {
		Long rId = Long.parseLong(id);
		Rental r = rentalRepository.findById(rId).get();
		return r;
	}

	@Transactional
	public int registerRental(String username, String rentalname, String region, String content) {
		Rental r = new Rental();
		r.setUser(userRepository.findByUsername(username));
		r.setRentalname(rentalname);
		r.setContent(content);
		r.setRegion(regionRepository.findByRegion(region));
		rentalRepository.saveAndFlush(r);
		return 1;
	}

	@Transactional
	public int updateRental(String id, String rentalname, String content) {
		int result = 0;
		
		Long rId = Long.parseLong(id);
		
		Rental r = rentalRepository.findById(rId).get();
		
		r.setRentalname(rentalname);
		r.setContent(content);
		rentalRepository.save(r);
		
		result = 1;
		
		return result;
	}

	@Transactional
	public int rentalDelete(String id) {
		int result = 0;
		
		Long rId = Long.parseLong(id);
		
		Rental r = rentalRepository.findById(rId).get();
		rentalRepository.delete(r);
		result = 1;
		
		return result;
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
				Carfile file = upload(e.getValue());
				
				// 성공하면 DB에도 저장
				if(file != null) {
					file.setCar_id(id); // FK
					file = carfileRepository.save(file); // INSERT
				}
			}
			return 1;
		
		} // end addFiles()

		// 물리적으로 파일 저장. 중복된 이름 처리
		private Carfile upload(MultipartFile multipartFile) {
			Carfile attachment = null;

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
			
	        attachment = Carfile.builder()
	        		.file(fileName) // 저장된 이름
	        		.source(sourceName) // 원본이름
	        		.build()
	        		;
			
			return attachment;
		}
			
		// [이미지 파일 여부 세팅]
		public void setImage(List<Carfile> fileList) {
			// upload 실제 물리적인 경로
			String realPath = context.getRealPath(uploadDir);
			
			for(Carfile fileDto : fileList) {
				BufferedImage imgData = null;
				File f = new File(realPath, fileDto.getFile());  // 첨부파일에 대한 File 객체
				try {
					imgData = ImageIO.read(f);
					// ※ ↑ 파일이 존재 하지 않으면 IOExcepion 발생한다
					//   ↑ 이미지가 아닌 경우는 null 리턴
				} catch (IOException e) {
					System.out.println("파일존재안함: " + f.getAbsolutePath() + " [" + e.getMessage() + "]");
				}					
				
				if(imgData != null) fileDto.setImage(true);// 이미지 여부 체크
			} // end for
		}
}
