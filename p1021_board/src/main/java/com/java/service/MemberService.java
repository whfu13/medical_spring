package com.java.service;

import com.java.dto.MemberDto;

public interface MemberService {

	// 자동 로그인 토큰으로 사용자 찾기
	MemberDto findByAutoLoginToken(String autoLoginToken);

}
