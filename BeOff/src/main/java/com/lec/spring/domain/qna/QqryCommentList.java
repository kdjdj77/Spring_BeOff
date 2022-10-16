//댓글의 목록을 담기 위한 용도
package com.lec.spring.domain.qna;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QqryCommentList extends QqryResult{
	@JsonProperty("data") //Json으로 매핑될 property name
	List<Qcomment> list; //목록데이터
}
