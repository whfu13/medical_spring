package com.java.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.dto.KakaoDto;
import com.java.dto.MemberDto;
import com.java.dto.OAuthTokenDto;
import com.java.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	private OAuthTokenDto oAuthTokenDto;

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
	} // signin
	
	// 아이디 저장 처리 메서드
	private void handleRememberMe(String rememberId, String memberId, HttpServletResponse response) {
		Cookie rememberCookie = new Cookie("rememberedId","remember".equals(rememberId) ? memberId : null);
		rememberCookie.setMaxAge("remember".equals(rememberId) ? 60 * 60 * 24 * 30 : 0 );
		rememberCookie.setPath("/");
		response.addCookie(rememberCookie);
		
	} // handleRememberMe

	// 자동 로그인 처리 메서드
	private void handleAutoLogin(String autoLogin, MemberDto mDto, HttpServletResponse response) {
		String autoLoginToken = "autoLogin".equals(autoLogin) ? memberService.generateAutoLoginToken(mDto) : null;
		Cookie autoLoginCookie = new Cookie("autoLoginToken", autoLoginToken);
		autoLoginCookie.setMaxAge("autoLogin".equals(autoLogin) ? 60 * 60 * 24 * 30 : 0);
		autoLoginCookie.setPath("/");
		response.addCookie(autoLoginCookie);
		
	} // handleAutoLogin
	
	// 로그아웃 처리
	@RequestMapping("/member/signout")
	public ModelAndView signout(HttpServletResponse response) {
		session.invalidate();
		
		Cookie autoLoginCookie = new Cookie("autoLoginToken", null);
		autoLoginCookie.setMaxAge(0);
		autoLoginCookie.setPath("/");
		response.addCookie(autoLoginCookie);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("chkSignIn",3);
		return mv;
		
	} // signout

	// 비밀번호 찾기 페이지로 이동
	@GetMapping("/member/forgotPassword")
	public String forgotPassword() {
		return "memeber/forgotPassword";
		
	} // forgotPassword
	
	// 비밀번호 찾기 처리
	@PostMapping("/member/forgotPassword")
	public ModelAndView forgotPassword(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		
		// 사용자 정보 찾기
		MemberDto memberDto = memberService.findByUsername(id);
		if(memberDto == null) {
			mv.addObject("message", "해당 아이디가 존재하지 않습니다.");
			mv.setViewName("member/forgotPassword");
			return mv;
		} 
		
		// 임시 비밀번호 생성 및 업데이트
		String tempPassword = generateTempPassword();
		memberDto.setPw(tempPassword);
		memberService.updatePassword(memberDto);
		mv.addObject("message", "임시 비밀번호가 이메일로 전송되었습니다.");
		mv.setViewName("member/forgotPassword");
		return mv;
		
	} // forgotPassword

	// 임시 비밀번호 생성 메서드
	private String generateTempPassword() {
		Random random = new Random();
		StringBuilder tempPassword = new StringBuilder();
		for(int i=0;i<8;i++) {
			tempPassword.append((char) (random.nextInt(26)+'a'));
		}
		return tempPassword.toString();
		
	} // generateTempPassword
	
	// 카카오 로그인 처리
	@RequestMapping("/kakao/oauth")
	public String oauth(String code) {
		String oauthUrl = "https://kauth.kakao.com/oauth/token";
		OAuthTokenDto oAuthTokenDto = requestKakaoToken(oauthUrl, code);
		
		String oauthUserUrl = "https://kapi.kakao.com/v2/user/me";
		KakaoDto kakaoDto = requestKakaoUser(oauthUserUrl, oAuthTokenDto.getAccess_token());
	
		session.setAttribute("session_id", kakaoDto.getId());
		session.setAttribute("session_nickName", kakaoDto.getProperties().getNickname());
	
		return "redirect:/";
		
	} // oauth

	// 카카오 토큰 요청 메서드
	private OAuthTokenDto requestKakaoToken(String url, String code) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "19855f07670ed426b71b6c31e02bb899");
		params.add("redirect_uri", "http://localhost:8181/kakao/oauth");
		params.add("code", code);
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
		ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.POST, request, String.class);

		try {
			return new ObjectMapper().readValue(response.getBody(), OAuthTokenDto.class);
		} catch (Exception e) {
			throw new RuntimeException("Failed to get OAuth token", e);
		}
		
	} // requestKakaoToken
	
	// 카카오 사용자 정보 요청 메서드
	private KakaoDto requestKakaoUser(String url, String accessToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + accessToken);
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);
		ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.POST, request, String.class);

		try {
			return new ObjectMapper().readValue(response.getBody(), KakaoDto.class);
		} catch (Exception e) {
			throw new RuntimeException("Failed to get Kakao user", e);
		}
		
	} // requestKakaoUser
	
	// 카카오 로그아웃 처리
	@RequestMapping("/kakao/logout")
	public String logout() {
		if(oAuthTokenDto != null && oAuthTokenDto.getAccess_token() != null) {
			String oauthLogoutUrl = "https://kapi.kakao.com/v1/user/unlink";
			logoutKakaoUser(oauthLogoutUrl, oAuthTokenDto.getAccess_token());
		}
		
		session.invalidate();
		return "redirect:/";
		
	} // logout

	// 카카오 로그아웃 요청 메서드
	private void logoutKakaoUser(String url, String accessToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + accessToken);
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);
		new RestTemplate().exchange(url, HttpMethod.POST, request, String.class);
	
	} // logoutKakaoUser

}
