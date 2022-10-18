package com.lec.spring.domain.rental;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
@Entity(name = "db_carfile")
public class Carfile {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, name = "car_id")
	@ManyToOne
	@ToString.Exclude
	private Car car;
	
	@Column(nullable = false)
	private String file;
	
	@Column(nullable = false)
	private String source;
	

}
