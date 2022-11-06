package com.lec.spring.domain.rental;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Entity(name = "db_car")
public class Car {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@ToString.Exclude
	private Rental rental; 
	
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
	
	@OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
	@ToString.Exclude
	@Builder.Default 
	private List<Carfile> files = new ArrayList<>();
	
	public void addFiles(Carfile... files) {
		if(files != null) {
			Collections.addAll(this.files, files);
		}
	}
	
	@OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
	@ToString.Exclude
	private List<Rentalticket> rentaltickets;
	
	public boolean enabled(String sDate, String eDate) {
		if (rentaltickets.isEmpty()) {
			return true;
		}
		
		Long start = Long.parseLong(sDate);
		Long end = Long.parseLong(eDate);
		return rentaltickets.stream().allMatch(ticket -> {
			return !(start <= ticket.getDate() && ticket.getDate() <= end);
		});
	}
}
