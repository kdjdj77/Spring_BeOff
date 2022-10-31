package com.lec.spring.domain.hotel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lec.spring.domain.qna.Qcomment;
import com.lec.spring.domain.qna.QqryCommentList;
import com.lec.spring.domain.qna.QqryResult;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HqryCommentList extends HqryResult{
	@JsonProperty("data") //Json으로 매핑될 property name
	List<Hcomment> list; //목록데이터
}
