package com.Yoo.blogpractice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Yoo.blogpractice.model.Category;
import com.Yoo.blogpractice.model.User;
import com.Yoo.blogpractice.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> 카테고리찾기(int userId){
		return categoryRepository.findAllByUserId(userId);
	}
	
	public void 카테저장(Category category, User user) {
		category.setUser(user);
		categoryRepository.save(category);
	}
}
