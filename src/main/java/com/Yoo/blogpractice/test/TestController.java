package com.Yoo.blogpractice.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {

	@GetMapping("/test/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("test/loginForm")
	public String loginForm() {
		return "/user/loginForm";
	}
	
	@GetMapping("test/joinForm")
	public String joinForm() {
		return "/user/joinForm";
	}
}
