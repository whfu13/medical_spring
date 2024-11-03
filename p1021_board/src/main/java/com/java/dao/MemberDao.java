package com.java.dao;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberDto;

@Mapper
public interface MemberDao {

	// 자동 로그인 토큰으로 사용자 찾기
	MemberDto findByAutoLoginToken(String autoLoginToken);

	// 로그인 시도
	MemberDto selectSignIn(MemberDto memberDto);

	// 아이디로 사용자 정보 찾기
	MemberDto findByUsername(String id);

	// 비밀번호 업데이트
	void updatePassword(MemberDto memberDto);

	// 자동 로그인 토큰 업데이트
	void updateAutoLoginToken(String id, String autoLoginToken);

	// 회원정보 저장
	void insertMember(MemberDto memberDto);

	// 아이디 중복체크
	int checkDuplicateId(String id);

	// 회원정보 조회
	MemberDto selectOne(String id);

}
