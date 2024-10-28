package com.java.service;

import com.java.dto.MemberDto;

public interface MemberService {

	// 자동 로그인 토큰으로 사용자 찾기
	MemberDto findByAutoLoginToken(String autoLoginToken);

	// 로그인 시도
	MemberDto selectSignIn(MemberDto memberDto);

	// 아이디로 사용자 정보 찾기
	MemberDto findByUsername(String id);

	// 비밀번호 업데이트
	void updatePassword(MemberDto memberDto);

	// 자동 로그인 토큰 생성
	String generateAutoLoginToken(MemberDto mDto);

}
