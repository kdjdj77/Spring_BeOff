package com.lec.spring.domain.hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HqryResult {
	int count; // 결과값 (정수)
	String status; // 결과 메세지
}
