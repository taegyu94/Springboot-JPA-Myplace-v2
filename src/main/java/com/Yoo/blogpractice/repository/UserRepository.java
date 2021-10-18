package com.Yoo.blogpractice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Yoo.blogpractice.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	//public User findByUsername(String username);
	
	Optional<User> findByUsername(String username); //.orElseThrow
	
	Optional<User> findByBlogname(String blogname);
	
}
