package com.lec.spring.domain.rental;

import java.util.Collections;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class TicketDTO {
	private Car car;
	private List<Long> date = new ArrayList<Long>();
	private float price;
	
	public void addDate(Long date) {
		this.date.add(date);
	}
	
	public List<Long> getDateList() {
		return this.date;
	}
	
	private LocalDateTime regDate;
	
	@JsonIgnore
	public String getRegDateTime() {
		if(this.regDate == null) return "";
		return this.regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));		
	}	
	
	public String getDateRange() {
		Long max = Collections.max(this.date);
		Long min = Collections.min(this.date);
		
		if (min - max == 0L) {
			return min + "";
		} else {
			return min + " ~ " + max;
		}
	}
}
