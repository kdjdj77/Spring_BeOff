package com.lec.spring.domain.hotel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

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
	private String hotelname; // 호텔 이름
	
	@Column
	private String content; // 호텔 내용
	
	@ColumnDefault(value = "0")
	private float avgstar; // 별점 평균
	
	// 금액을 받아오는 list
	@Transient
	private String priceList;
	
	@ManyToOne
	@ToString.Exclude
	private User user;
	
	@ManyToOne
	@ToString.Exclude
	private Region region;
	

    @OneToMany(mappedBy ="hotel" , cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private List<Room> rooms = new ArrayList<>();

	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	@ToString.Exclude
	@Builder.Default
	private List<Hcomment> hcomments = new ArrayList<>();
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	@ToString.Exclude
	@Builder.Default  // 아래와 같이 초깃값 있으면 @Builder.Default 처리  (builder 에서 제공안함)
	private List<Hotelfile> files = new ArrayList<>();  // NPE 방지

	public void addFiles(Hotelfile... files) {  // xxxToMany 의 경우 만들어두면 편리
		if(files != null) {
			Collections.addAll(this.files, files);
		}
	}


}
