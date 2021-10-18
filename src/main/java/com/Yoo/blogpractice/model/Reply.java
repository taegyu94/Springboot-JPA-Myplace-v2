package com.Yoo.blogpractice.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 300)
	private String content;
	
	@ManyToOne(fetch = FetchType.EAGER)	//패치옵션 기본값 : EAGER
	@JoinColumn(name="userId")
	@JsonIgnoreProperties({"board"})
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="boardId")
	private Board board;
	
	private Timestamp createDate;
}
