package com.java.service;

import java.util.UUID;

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

	@Override	// 로그인 시도
	public MemberDto selectSignIn(MemberDto memberDto) {
		return memberDao.selectSignIn(memberDto);
	}

	@Override	// 아이디로 사용자 정보 찾기
	public MemberDto findByUsername(String id) {
		return memberDao.findByUsername(id);
	}

	@Override	// 비밀번호 업데이트
	public void updatePassword(MemberDto memberDto) {
		memberDao.updatePassword(memberDto);
	}

	@Override	// 자동 로그인 토큰 생성
	public String generateAutoLoginToken(MemberDto mDto) {
		String autoLoginToken = UUID.randomUUID().toString();
        memberDao.updateAutoLoginToken(mDto.getId(), autoLoginToken);
        return autoLoginToken;
	}

}
