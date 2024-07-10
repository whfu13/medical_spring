package com.java.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

@Mapper
public interface MemberMapper {
	
	// 로그인체크
	MemberDto selectLogin(String id, String pw);
	

}
