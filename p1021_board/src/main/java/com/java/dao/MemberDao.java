package com.java.dao;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberDto;

@Mapper
public interface MemberDao {

	// 자동 로그인 토큰으로 사용자 찾기
	MemberDto findByAutoLoginToken(String autoLoginToken);

}
