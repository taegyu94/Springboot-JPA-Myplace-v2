package com.Yoo.blogpractice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Yoo.blogpractice.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	public List<Category> findAllByUserId(int userId);
}
