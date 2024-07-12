package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.MemDto;
import com.java.mapper.MemMapper;
import com.java.service.MemService;

@Controller
public class MemController {
	
	@Autowired
	MemService memService;
	
	@RequestMapping("/mem/login")
	public String login() {
		return "/mem/login";
	}
	@RequestMapping("/mem/doLogin")
	public ModelAndView doLogin(MemDto mdto) {
		MemDto memDto = memService.selectLogin(mdto);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("memDto",memDto);
		mv.setViewName("/mem/doLogin");
		return mv;
	}
}
