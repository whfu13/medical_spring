package com.java.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.dto.MemberDto;
import com.java.dto.OAuthTokenDto;
import com.java.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private HttpSession session;

	// @Autowired private JavaMailSender mailSender;

	private OAuthTokenDto oAuthTokenDto;

	// 로그인 페이지로 이동
	@GetMapping("/member/signin")
	public ModelAndView signin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("member/signin");
		String rememberedId = null;

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("rememberedId".equals(cookie.getName())) {
					rememberedId = cookie.getValue();
				} else if ("autoLoginToken".equals(cookie.getName())) {
					MemberDto memberDto = memberService.findByAutoLoginToken(cookie.getValue());
					if (memberDto != null) {
						session.setAttribute("sessionId", memberDto.getId());
						mv.setViewName("redirect:/");
						return mv;
					}
				}
			}
		}
		mv.addObject("rememberedId", rememberedId);
		return mv;
	}

	// 로그인 처리
	@PostMapping("/member/signin")
	public ModelAndView signin(MemberDto memberDto, String rememberId, String autoLogin, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		// 로그인 시도
		MemberDto mDto = memberService.selectSignIn(memberDto);
		if (mDto == null) {
			// 임시 비밀번호로 로그인 시도
			mDto = memberService.findByUsername(memberDto.getId());
			if (mDto != null && memberDto.getPw().equals(mDto.getTempPw())) {
				memberService.updatePassword(memberDto);
			} else {
				mv.addObject("chkSignIn", 0);
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
		mv.addObject("chkSignIn", 1);
		mv.setViewName("member/dosignin");
		return mv;
	}

	// 아이디 저장 처리 메서드
	private void handleRememberMe(String rememberId, String memberId, HttpServletResponse response) {
		Cookie rememberCookie = new Cookie("rememberedId", "remember".equals(rememberId) ? memberId : null);
		rememberCookie.setMaxAge("remember".equals(rememberId) ? 60 * 60 * 24 * 30 : 0);
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

	// 로그아웃 처리
	@RequestMapping("/member/signout")
	public ModelAndView signout(HttpServletResponse response) {
		session.invalidate();

		Cookie autoLoginCookie = new Cookie("autoLoginToken", null);
		autoLoginCookie.setMaxAge(0);
		autoLoginCookie.setPath("/");
		response.addCookie(autoLoginCookie);

		ModelAndView mv = new ModelAndView("member/dosignin");
		mv.addObject("chkSignIn", 3);
		return mv;
	}

	// 비밀번호 찾기 페이지로 이동
	@GetMapping("/member/forgotPassword")
	public String forgotPasswordForm() {
		return "member/forgotPassword";
	}

}