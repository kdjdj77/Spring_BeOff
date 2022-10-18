package com.lec.spring.domain.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Entity(name = "db_itemfile")
public class Itemfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "item_id")
	private Long item;     // 어느글의 첨부파일?
	
	@Column(nullable = false)
	private String source;   // 원본 파일 명
	@Column(nullable = false)
	private String file;     // 저장된 파일 명 (rename 된 파일명)

}
