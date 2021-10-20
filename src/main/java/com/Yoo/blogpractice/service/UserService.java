package com.Yoo.blogpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Yoo.blogpractice.model.RoleType;
import com.Yoo.blogpractice.model.User;
import com.Yoo.blogpractice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Transactional
	public void 회원가입(User user) {
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
	
	@Transactional
	public User 블로그주인찾기(String blogname){
		return userRepository.findByBlogname(blogname)
				.orElseThrow(()->{
					return new IllegalArgumentException("blog 진입 실패 : 블로그를 찾을 수 없습니다.");
				});
	}
	
	@Transactional(readOnly = true)
	public Page<User> 모든유저찾기(Pageable pageable){
		return userRepository.findAll(pageable);
	}
}
