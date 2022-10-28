package com.lec.spring.domain.hotel;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Transient;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@Entity(name="db_hotelfile")
public class Hotelfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(name="hotel_id")
	private Long hotel;


	@Column(nullable = false)
	private String source;  
	@Column(nullable = false)
	private String file;
	
//	@Transient
//	private boolean isImage; // 이미지 여부
}
