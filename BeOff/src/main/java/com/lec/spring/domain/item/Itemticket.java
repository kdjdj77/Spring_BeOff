package com.lec.spring.domain.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

@Entity(name="db_itemticket")
public class Itemticket extends BaseEntity{
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

	@Column(nullable=false)
	private Long count; // 상품 수량
	
	@Column
	@Enumerated(EnumType.STRING)
	private Orderstatus orderstatus; // 상품 주문 상태
	
	
}
