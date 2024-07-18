package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MController {

	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	@PostMapping("/member/login")
	public ModelAndView login(MemberDto memberDto) {
		
		int chkLogin = 0;
		MemberDto mDto = memberService.selectLogin(memberDto);
		
		if(mDto!=null) {
			chkLogin = 1;
			session.setAttribute("sessionId",mDto.getId());
			session.setAttribute("sessionName",mDto.getName());
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("chkLogin",chkLogin);
		mv.setViewName("member/doLogin");
		
		return mv;
	}
	@RequestMapping("/member/logout")
	public ModelAndView logout() {
		
		int chkLogin = 3;
		session.invalidate();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("chkLogin",chkLogin);
		mv.setViewName("member/doLogin");
		
		return mv;
	}
}
