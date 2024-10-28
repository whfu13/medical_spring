package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	// 로그인 처리
	@PostMapping("/member/signin")
	public ModelAndView signin(MemberDto memberDto, String rememberId, String autoLogin, HttpServletResponse response ) {
		ModelAndView mv = new ModelAndView();
		
		// 로그인 시도
		MemberDto mDto = memberService.selectSignIn(memberDto);
		if(mDto == null) {
			// 임시 비밀번호로 로그인 시도
			mDto = memberService.findByUsername(memberDto.getId());
			if(mDto != null && memberDto.getPw().equals(mDto.getTempPw())) {
				memberService.updatePassword(memberDto);
			} else {
				mv.addObject("chkSignIn",0);
				mv.setViewName("member/dosignin");
				return mv;
			}
		}
		
		// 세션 설정
		session.setAttribute("sessionId", mDto.getId());
		session.setAttribute("sessionPw", mDto.getPw());
		
		// 아이디 저장 처리
		handleRememberMe(rememberId, mDto.getId(), response);
		handleAutoLogin(autoLogin, mDto, response);
		
		// 로그인 처리
		mv.addObject("chkSignIn",1);
		mv.setViewName("member/dosignin");
		return mv;
	}
	
	// 아이디 저장 처리 메서드
	private void handleRememberMe(String rememberId, String memberId, HttpServletResponse response) {
		Cookie rememberCookie = new Cookie("rememberedId","remember".equals(rememberId) ? memberId : null);
		rememberCookie.setMaxAge("remember".equals(rememberId) ? 60 * 60 * 24 * 30 : 0 );
		rememberCookie.setPath("/");
		response.addCookie(rememberCookie);
	}

	// 자동 로그인 처리 메서드
	private void handleAutoLogin(String autoLogin, MemberDto mDto, HttpServletResponse response) {
		String autoLoginToken = "autoLogin".equals(autoLogin) ? memberService.generateAutoLoginToken(mDto) : null;
		Cookie autoLoginCookie = new Cookie("autoLoginToken", autoLoginToken);
		autoLoginCookie.setMaxAge("autoLogin".equals(autoLogin) ? 60 * 60 * 24 * 30 : 0);
		autoLoginCookie.setPath("/");
		response.addCookie(autoLoginCookie);
	}

}
