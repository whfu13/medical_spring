package com.java.service;

import java.util.ArrayList;
import java.util.List;

import com.java.dto.MemberDto;

public interface MemberService {

	// 로그인 시도
	MemberDto selectSignIn(MemberDto memberDto);

	// 자동 로그인 토큰으로 사용자 찾기
	MemberDto findByAutoLoginToken(String autoLoginToken);

	// 자동 로그인 토큰 생성
	String generateAutoLoginToken(MemberDto mDto);

	// 아이디로 사용자 정보 찾기
	MemberDto findByUsername(String id);

	// 비밀번호 업데이트
	void updatePassword(MemberDto memberDto);
}