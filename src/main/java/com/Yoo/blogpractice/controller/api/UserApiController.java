package com.Yoo.blogpractice.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Yoo.blogpractice.dto.ResponseDto;
import com.Yoo.blogpractice.model.User;
import com.Yoo.blogpractice.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		userService.회원가입(user);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value() , 1);
	}
	
	@GetMapping("/auth/searchProc/{searchBlogname}")
	public ResponseDto<Integer> searchBlogname(@PathVariable String searchBlogname){
		userService.블로그주인찾기(searchBlogname);
		return new ResponseDto<Integer>(HttpStatus.OK.value() , 1);
	}
	
}
