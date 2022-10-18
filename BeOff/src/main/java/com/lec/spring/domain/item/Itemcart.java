package com.lec.spring.domain.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.lec.spring.domain.User;

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
@Entity(name = "db_itemcart")

public class Itemcart{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	

	// N:1(relation)
	@ManyToOne
	@ToString.Exclude
	private User user;
	@ManyToOne
	@ToString.Exclude
	private Item item; 
	
	@Column
	private Long count; // 상품 갯수
	@Column
	private float orderprice; // 주문 가격

}
