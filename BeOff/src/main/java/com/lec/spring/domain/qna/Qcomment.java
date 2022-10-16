package com.lec.spring.domain.qna;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lec.spring.domain.BaseEntity;
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
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity(name="db_qcomment")
public class Qcomment extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//Comment:User = N:1
	@ManyToOne
	@ToString.Exclude
	private User user; // 댓글 작성자 (FK)
	@Column(name="write_id")
	@JsonIgnore
	private Long write;
	@Column(nullable=false)
	private String content; //댓글 내용
}
