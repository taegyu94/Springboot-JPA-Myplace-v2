package com.Yoo.blogpractice.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int count;
	
	private String title;
	
	@Lob		//대용량 데이터
	private String content;
	
	@ManyToOne(fetch = FetchType.EAGER)	//무조건 가져오기 .   LAZY -> 필요하면 가져오기 , 기본값 : EAGER
	@JsonIgnoreProperties({"board","category"})
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"board","user"})
	@JoinColumn(name = "categoryId")
	private Category category;
	
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER , cascade = CascadeType.REMOVE)	// 무조건 가져오기  >  기본값은 LAZY 이나 댓글을 무조건 가져오기를 원한다.  ,cascade 옵션으로 게시글을 지울때 댓글과 함께 삭제
	@JsonIgnoreProperties({"board"})	//Reply의 board 로 인해 무한 참조 현상이 생기기때문에 이를 무시한다.
	@OrderBy("id desc")	//id값을 기준으로 내림차순으로 정렬
	private List<Reply> replys;
	
	@CreationTimestamp
	private Timestamp createDate;
}
