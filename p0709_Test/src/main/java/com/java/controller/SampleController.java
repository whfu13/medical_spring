package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.SampleDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SampleController {
	@RequestMapping("/sample/info")
	public String info() {
		return "sample/info";
	}
	@RequestMapping("/sample/doInfo")
	public ModelAndView doInfo(SampleDto sp) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("sp",sp);
		mv.setViewName("sample/doInfo");
		
		return mv;
	}
}
