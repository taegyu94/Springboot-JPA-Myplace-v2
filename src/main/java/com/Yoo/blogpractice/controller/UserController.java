package com.Yoo.blogpractice.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Yoo.blogpractice.config.auth.PrincipalDetails;

@Controller
public class UserController {
	
	/*
	@GetMapping({"","/"})
	public String home(@AuthenticationPrincipal PrincipalDetails principal) {
		System.out.println("로그인 사용자 아이디 : "+principal.getUsername());
		return "index";
	}*/
	
	@GetMapping({"","/"})
	public String home() {
		return "index";
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
