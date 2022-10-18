package com.lec.spring.domain.rental;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Columns;

import com.lec.spring.domain.qna.FileDTO;

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
@Entity(name = "db_car")
public class Car {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@ManyToOne
	@ToString.Exclude
	private Long rental_id; 
	
	@Column(nullable = false)
	private String carname;
	
	@Column(nullable = false)
	private float price;
	
	@Column(nullable = false)
	private String cartype;
	
	@Column
	private String fuel;
	
	@Column
	private String fueleff;
	

}
