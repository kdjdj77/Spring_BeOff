package com.lec.spring.domain.item;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.lec.spring.domain.BaseEntity;
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

@Entity(name="db_item")
@DynamicInsert    
@DynamicUpdate    
public class Item extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	// 상품 id
	
	// N:1 (relation)
	@ManyToOne
	@ToString.Exclude
	private User user;
	
	@Column(nullable = false)
	private String name; // 상품명
	@Column(nullable = false)
	private String content; // 상품 설명
	@Column(nullable = false)
	private float price; // 상품 가격
	@Column(nullable = false)
	private Long stock;	// 재고 수량
	@Column(nullable = false)
	private float avgstar; // 총 별점
	@ColumnDefault(value = "0")
	private Long viewcnt; // 조회수
	@Column
	@Enumerated(EnumType.STRING)
	private Sellstatus sellstatus; // 상품 판매 상태
	
	// 1:N (relation)
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)  
	@ToString.Exclude
	@Builder.Default
	private List<Icomment> comments = new ArrayList<>();
	
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	@ToString.Exclude
	@Builder.Default  
	private List<Itemfile> files = new ArrayList<>();  
	public void addFiles(Itemfile... files) {  
		if(files != null) {
			Collections.addAll(this.files, files);
		}
	}

}
