package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberDao;
import com.java.dto.MemberDto;

@Service
public class SignInServiceImpl implements SignInService {
	
	@Autowired MemberDao memberDao;
	
	@Override //로그인 확인
	public MemberDto selectSignIn(MemberDto memberDto) {
		MemberDto mDto = memberDao.selectSignIn(memberDto);
		return mDto;
	}

}
