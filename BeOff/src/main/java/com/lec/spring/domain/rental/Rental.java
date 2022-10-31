package com.lec.spring.domain.rental;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
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
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity(name = "db_rental")
public class Rental extends BaseEntity{
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@ToString.Exclude
	private Region region;
	
	@ManyToOne
	@ToString.Exclude
	private User user;
	
	@Column(nullable = false)
	private String rentalname;
	
	@Column
	private String content;
	
	@ColumnDefault(value = "0")
	private float avgstar;
	
	@OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
	@ToString.Exclude
	@Builder.Default 
	private List<Car> cars = new ArrayList<>();
	
}
