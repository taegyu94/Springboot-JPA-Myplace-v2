package com.Yoo.blogpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Yoo.blogpractice.config.auth.PrincipalDetails;
import com.Yoo.blogpractice.model.User;
import com.Yoo.blogpractice.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping({"","/"})
	public String home(Model model, @PageableDefault(size = 3 , sort = "id" , direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("users", userService.모든유저찾기(pageable));
		return "index";
	}
	
	@GetMapping("/search/{searchBlogname}")
	public String searchBlogForm(Model model, @PathVariable String searchBlogname) {
		model.addAttribute("searchblog", userService.블로그주인찾기(searchBlogname));
		return "/user/searchBlogForm";
	}

	@GetMapping("/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "/user/joinForm";
	}
	

	
}
