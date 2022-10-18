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
@Entity(name="db_room")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	@ToString.Exclude
	@Builder.Default  // 아래와 같이 초깃값 있으면 @Builder.Default 처리  (builder 에서 제공안함)
	private List<Roomfile> files = new ArrayList<>();  // NPE 방지

	public void addFiles(Roomfile... files) {  // xxxToMany 의 경우 만들어두면 편리
		if(files != null) {
			Collections.addAll(this.files, files);
		}
	}
	
//	@Column(name = "hotel_id") // 이게 왜안되지
//	private Long hotel; // 어느 호텔의 룸 ? (FK)
	
	@ManyToOne
	@ToString.Exclude
	private Hotel hotel;
	
	@Column(nullable = false)
	private String roomname;
	@Column(nullable = false)
	private float price;
	@Column(nullable=false)
	private Long bed;
}
