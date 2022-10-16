package com.lec.spring.domain.qna;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QqryResult {
	int count; // 결과값 (정수)
	String status; // 결과 메시지
}
