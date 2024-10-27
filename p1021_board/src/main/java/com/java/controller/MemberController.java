package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired MemberService memberService;
	@Autowired HttpSession session;

	@RequestMapping("/member/signin")
	public ModelAndView signin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("member/signin");
		String rememberedId = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if("rememberedId".equals(cookie.getName())) {
					rememberedId = cookie.getValue();
				} else if("autoLoginToken".equals(cookie.getName())) {
					MemberDto memberDto = memberService.findByAutoLoginToken(cookie.getValue());
					if (memberDto != null) {
						session.setAttribute("sessionId",memberDto.getId());
						mv.setViewName("redirect:/");
						return mv;
					}
				}
					
			}
		}
		mv.addObject("rememberedId",rememberedId);
		return mv;
		
	} // signin
}
