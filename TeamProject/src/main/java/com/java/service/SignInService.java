package com.java.service;

import com.java.dto.MemberDto;

public interface SignInService {
	//로그인 확인
	MemberDto selectSignIn(MemberDto memberDto);

}
