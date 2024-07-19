package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/introduce")
public class IntroduceController {
	
	@RequestMapping("/introduce")
	public String introduce() {
		return "introduce/introduce";
	}//소개페이지
	
}//class
