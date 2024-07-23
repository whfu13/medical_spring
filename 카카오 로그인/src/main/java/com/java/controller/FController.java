package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.dto.KakaoDto;
import com.java.dto.LogoutDto;
import com.java.dto.OAuthTokenDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	@Autowired
	private HttpSession session;
	
	@Value("${kakao.admin_id}")
	private String id;
	

	// 토큰키 객체
	OAuthTokenDto oAuthTokenDto = null;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}

	// 로그아웃
	@RequestMapping("/kakao/logout")
	public String logout() {
		
		// 로컬 서버에서만 섹션 종료
		session.invalidate();
		
		
		// 1. 카카오 섹션 종료 - 로그아웃
		// 사용자 정보 가져오기
		String oauthLogoutUrl = "https://kapi.kakao.com/v1/user/unlink";
		String authorization = "Bearer "+oAuthTokenDto.getAccess_token();
				
		// HttpHeaders 생성
		HttpHeaders headers_logout = new HttpHeaders();
		headers_logout.add("Authorization", authorization);
		
		// HttpEntity - HttpHeaders, HttpBody 1개의 오브젝트 생성
		HttpEntity<MultiValueMap<String, String>> kakaoTokenLogoutRequest = 
				new HttpEntity<>(headers_logout);
		
		// http 전송 - HttpEntity
		RestTemplate rt_logout = new RestTemplate();
		ResponseEntity<String> response = rt_logout.exchange(oauthLogoutUrl, HttpMethod.POST,kakaoTokenLogoutRequest,String.class);
		
		System.out.println("1.kakaoTokenLogout response Json 타입 : "+response);
		
		// json 파일을 java파일로 변경
		ObjectMapper objectMapper = new ObjectMapper();
		LogoutDto logoutDto = null;
		
		try {
			logoutDto = objectMapper.readValue(response.getBody(), LogoutDto.class);
		} catch (Exception e) {e.printStackTrace();}
		
		System.out.println("1.logoutDto class : "+logoutDto.getId());
		System.out.println("카카오 로그아웃 완료");
		
		// 로컬 서버에서만 섹션 종료
		session.invalidate();
		return "redirect:/";
	}
	
	// 카카오 로그인
	@RequestMapping("/kakao/oauth")
//	@ResponseBody
	public String oauth(String code) {
		System.out.println("1. code : "+code);
		
		//-------------토큰 요청 => 인터넷 url로 전송-post ---------------------
		String oauthUrl = "https://kauth.kakao.com/oauth/token";
		String content_type = "application/x-www-form-urlencoded;charset=utf-8";
		String grant_type = "authorization_code";
		String client_id = "767b75bf1e6051c46a48729b70f77d1c";
		String redirect_uri = "http://localhost:8181/kakao/oauth";
//		code = code;
		
		// HttpHeaders 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", content_type);
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("grant_type", grant_type);
		map.add("client_id", client_id);
		map.add("redirect_uri", redirect_uri);
		map.add("code", code);
		
		
		// HttpEntity - HttpHeaders, HttpBody 1개의 오브젝트 생성
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = 
				new HttpEntity<>(map,headers);
		
		// http 전송 - HttpEntity
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> response = rt.exchange(oauthUrl, HttpMethod.POST,kakaoTokenRequest,String.class);
		
		System.out.println("2. 카카오 토큰 요청에 대한 응답 : "+response);
		
		// json 파일을 java파일로 변경
		ObjectMapper objectMapper = new ObjectMapper();
		// 상단에 선언
		// oAuthTokenDto = null;
		
		try {
			oAuthTokenDto = objectMapper.readValue(response.getBody(), OAuthTokenDto.class);
		} catch (Exception e) {e.printStackTrace();}
		
		System.out.println("3. kakaoToken : "+oAuthTokenDto.getAccess_token());
		
		
		// 사용자 정보 가져오기
		String oauthUserUrl = "https://kapi.kakao.com/v2/user/me";
		String authorization = "Bearer "+oAuthTokenDto.getAccess_token();
		content_type = "application/x-www-form-urlencoded;charset=utf-8";
		
		
		// header오브젝트 생성
		HttpHeaders headers_user = new HttpHeaders();
		headers_user.add("Content-type", content_type);
		headers_user.add("Authorization", authorization);
		
	
		// HttpEntity - HttpHeaders, HttpBody 1개의 오브젝트 생성
		HttpEntity<MultiValueMap<String, String>> kakaoTokenUserRequest =
				new HttpEntity<>(headers_user);
		
		// http 전송 - HttpEntity
		RestTemplate rt_user = new RestTemplate();
		ResponseEntity<String> response_user = rt_user.exchange(oauthUserUrl, HttpMethod.POST,kakaoTokenUserRequest,String.class);
		System.out.println("response_user : "+response_user);
		// json 파일을 java파일로 변경
		ObjectMapper objectMapper_user = new ObjectMapper();
		KakaoDto kakaoDto = null;
		
		try {
			kakaoDto = objectMapper_user.readValue(response_user.getBody(), KakaoDto.class);
			
		} catch (Exception e) {e.printStackTrace();}
		
		System.out.println("4.kakaoUserToken class id : "+kakaoDto.getId());
		System.out.println("5.kakaoUserToken class Nickname : "+kakaoDto.getProperties().getNickname());

		
		// 로그인의 섹션 생성 후 로그인 완료
		session.setAttribute("session_id",kakaoDto.getId());
		session.setAttribute("session_Nickname",kakaoDto.getProperties().getNickname());
		
		
//		return "kakaoToken class id : "+kakaoDto.getId();
		return "redirect:/";
	}
	
	
}
