package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberDao;
import com.java.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberDao memberDao;
	
	@Override	// 자동 로그인 토큰으로 사용자 찾기
	public MemberDto findByAutoLoginToken(String autoLoginToken) {
		return memberDao.findByAutoLoginToken(autoLoginToken);
	}

}
