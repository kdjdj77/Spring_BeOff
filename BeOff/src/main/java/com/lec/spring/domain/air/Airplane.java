package com.lec.spring.domain.air;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.lec.spring.domain.Region;

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
@Entity(name="db_airplane")
public class Airplane {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@ToString.Exclude
	private Region depart;
	@ManyToOne
	@ToString.Exclude
	private Region arrive;
	@ManyToOne
	@ToString.Exclude
	private Airtime time;
	@ManyToOne
	@ToString.Exclude
	private Airname name;
}
