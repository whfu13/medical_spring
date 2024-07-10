package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.service.MemberService;
import com.java.service.MemberServiceImpl;

@Controller
public class FrontController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/member/login") // 로그인화면
	public String login() {
		return "/member/login";
	}
	@RequestMapping("/member/doLogin")
	public ModelAndView doLogin(String id, String pw, int pno) {
		System.out.println("id : "+id);
		System.out.println("pw : "+pw);
		System.out.println("pno : "+pno);
		
		int check = memberService.loginCheck(id,pw,pno);
		//check 출력
		System.out.println("로그인 성공 확인 여부 : "+check);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",id);
		mv.addObject("pw",pw);
		mv.addObject("pno",pno);
		mv.addObject("check",check);
		mv.setViewName("/member/doLogin");
		
		return mv;
	}
}
