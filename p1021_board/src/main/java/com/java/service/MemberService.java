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

	// 회원정보 저장
	void insertMember(MemberDto memberDto);

	// 아이디 중복체크
	boolean isDuplicated(String id);

	// 회원정보 가져오기
	MemberDto selectOne(String id);

	// 회원정보 수정
	void updateMember(MemberDto memberDto);

	// 회원탈퇴
	void deleteMember(String id);

}
