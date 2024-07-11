package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.MemDto;
import com.java.mapper.MemMapper;
import com.java.service.MemService;

@Controller
public class MemController {
	
	memberservice
	
	@RequestMapping("/mem/login")
	public String login() {
		return "/mem/login";
	}
	@RequestMapping("/mem/doLogin")
	public String doLogin(MemDto mdto) {
		MemDto mdto = MemService.selectLogin(mdto);
		
		return "/mem/doLogin";
	}
}
