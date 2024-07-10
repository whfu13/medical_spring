package com.java.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller

// get,post 방식 / put,delete 방식
public class FrontController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	// get, post 방식 둘다 사용
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/member")
	public String member() {
		return "member";
	}

	
	@RequestMapping("/doMember")
	public ModelAndView doMember(HttpServletRequest request) {
		System.out.println("id : "+request.getParameter("id"));
		System.out.println("name : "+request.getParameter("name"));
		String[] hobby = request.getParameterValues("hobby");
		String hobbys = ""; // game,golf,run,swim,book
		for(int i=0;i<hobby.length;i++) {
			if(i==0) hobbys += ""+hobby[i];
			else hobbys += ","+hobby[i];
		}
		System.out.println("hobby : "+hobbys);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",request.getParameter("id"));
		mv.addObject("pw",request.getParameter("pw"));
		mv.addObject("name",request.getParameter("name"));
		mv.addObject("phone",request.getParameter("phone"));
		mv.addObject("gender",request.getParameter("gender"));
		mv.addObject("hobby",Arrays.toString(hobby));
		mv.setViewName("doMember"); // 파일이름
		
		return mv;
	}

	@RequestMapping("/memUpdate") // 회원정보수정
	public ModelAndView memUpdate(HttpServletRequest request) {
		String[] hobby = request.getParameterValues("hobby");
		String hobbys = ""; // game,golf,run,swim,book
		for(int i=0;i<hobby.length;i++) {
			if(i==0) hobbys += ""+hobby[i];
			else hobbys += ","+hobby[i];
		}
		System.out.println("hobby : "+hobbys);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",request.getParameter("id"));
		mv.addObject("pw",request.getParameter("pw"));
		mv.addObject("name",request.getParameter("name"));
		mv.addObject("phone",request.getParameter("phone"));
		mv.addObject("gender",request.getParameter("gender"));
		mv.addObject("hobby",Arrays.toString(hobby));
		mv.setViewName("doMember"); // 파일이름
		
		return mv;
	}
}
