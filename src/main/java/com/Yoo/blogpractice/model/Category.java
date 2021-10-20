package com.Yoo.blogpractice.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false , length = 40)
	private String subject;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"board","category"})
	@JoinColumn(name = "userId")
	private User user;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"category","user"})
	@OrderBy("id desc")
	private List<Board> board;
	
	@CreationTimestamp
	private Timestamp createDate;
}
