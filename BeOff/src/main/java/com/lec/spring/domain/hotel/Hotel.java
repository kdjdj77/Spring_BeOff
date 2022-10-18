package com.lec.spring.domain.hotel;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;

import com.lec.spring.domain.BaseEntity;
import com.lec.spring.domain.Region;
import com.lec.spring.domain.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity(name="db_hotel")
public class Hotel extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name; // 호텔 이름
	
	private String content; // 호텔 내용
	@ColumnDefault(value = "0")
	private float avgstar; // 별점 평균
	@ManyToOne
	private User user;
	@ManyToOne
	private Region region;
//	@OneToMany
//	private List<Room> rooms = new ArrayList<>();
	@OneToMany
	private List<Hcomment> hcomments = new ArrayList<>();
	
	// one to many -- comment -- hotel : comment
	// one to many -- room -- hotel : room

}
