package com.lec.spring.domain.item;

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
@Entity(name = "db_icomment")
public class Icomment extends BaseEntity{
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// N:1(relation)
	@ManyToOne
	@ToString.Exclude
	private User user; 
	@ManyToOne
	@ToString.Exclude
	private Item item_id;

		
	@Column(name = "item_id")
	@JsonIgnore
	private Long item;   // 게시글 (FK)
		
	@Column(nullable = false)
	private String content;   // 댓글 내용
		
	private Long star; // 별점
}
