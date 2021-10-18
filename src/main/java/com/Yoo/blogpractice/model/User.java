package com.Yoo.blogpractice.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100, unique = true)
	private String username;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@Column(nullable = false, length = 50 , unique = true)
	private String blogname;
	
	/////////////////////
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"user"})
	@OrderBy("id desc")
	private List<Board> board;
	
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	@CreationTimestamp
	private Timestamp createDate;
}
