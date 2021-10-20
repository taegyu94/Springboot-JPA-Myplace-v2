package com.Yoo.blogpractice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Yoo.blogpractice.model.Category;
import com.Yoo.blogpractice.model.User;
import com.Yoo.blogpractice.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional
	public List<Category> 카테고리찾기(int userId){
		return categoryRepository.findAllByUserId(userId);
	}
	
	@Transactional
	public void 카테저장(Category category, User user) {
		category.setUser(user);
		categoryRepository.save(category);
	}
	
	@Transactional
	public void 카테삭제(int categoryId) {
		categoryRepository.deleteById(categoryId);
	}
	
	
	
}
