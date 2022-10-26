package com.lec.spring.domain.qna;

import java.util.Collections;
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
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity(name="db_qna")
@DynamicInsert // insert 동작 시 null인 필드는 제외
@DynamicUpdate // update 동작 시 null인 필드는 제외
public class Qna extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Long id;		// 글의 id(PK)
	@Column(nullable=false)
	private String subject;	// 글의 제목
	@Column(nullable=false)
	private String content;	// 글 내용
	@ColumnDefault(value = "0")
	private int viewCnt;	// 글 조회수
	// Write:User = N:1
	@ManyToOne
	@ToString.Exclude
	private User user;
	@OneToMany(mappedBy = "write", cascade = CascadeType.ALL)  // 삭제등의 동작 발생시 child 도 함께 삭제
	@ToString.Exclude
	@Builder.Default
	private List<Qcomment> comments = new ArrayList<>();
	
	@OneToMany(mappedBy = "write", cascade = CascadeType.ALL)
	@ToString.Exclude
	@Builder.Default  // 아래와 같이 초깃값 있으면 @Builder.Default 처리  (builder 에서 제공안함)
	private List<Roomfile> files = new ArrayList<>();  // NPE 방지
	
	public void addFiles(Roomfile... files) {  // xxxToMany 의 경우 만들어두면 편리
		if(files != null) {
			Collections.addAll(this.files, files);
		}
	}
}
