package com.lec.spring.domain.air;

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
public class AirDTO {
	private String depart;
	private String arrive;
	private String time;
	private String name;
	private float price;
	private int remain;
	private String date;
}
