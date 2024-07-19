package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.MemberDto;
import com.java.service.SignInService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/signIn")
public class SignInController {
	
	@Autowired SignInService signInService;
	@Autowired HttpSession session;
	
	@GetMapping("/signIn")
	public String signIn() {
		return "signIn/signIn";
	}//로그인페이지
	
	@PostMapping("/signIn")
	public ModelAndView signIn(MemberDto memberDto) {
		System.out.println("controller id : "+memberDto.getId());
		System.out.println("controller pw : "+memberDto.getPw());
		
		//로그인 확인
		int chkLogin = 0;
		MemberDto mDto = signInService.selectSignIn(memberDto);
		
		if(mDto != null) {
			chkLogin = 1;
			System.out.println("controller name : "+mDto.getName());
			session.setAttribute("sessionId", mDto.getId());
			session.setAttribute("sessionName", mDto.getName());
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("chkLogin",chkLogin);
		mv.setViewName("signIn/doSignIn");
		
		return mv;
	}//로그인확인
	
	
}//class
