package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signUp")
public class SignUpController {
	
	@RequestMapping("/signUp")
	public String signUp() {
		return "signUp/signUp";
	}//회원가입 페이지
	
}//class
