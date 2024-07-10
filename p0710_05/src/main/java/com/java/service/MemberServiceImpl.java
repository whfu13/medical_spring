package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.MemberDto;
import com.java.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public MemberDto selectLogin(MemberDto mdto) {
		System.out.println("serviceImpl id : "+mdto.getId());
		System.out.println("serviceImpl pw : "+mdto.getPw());
		
		// DB 연결해서 객체 1개 가져오기
		MemberDto memberDto = MemberMapper.selectLogin(mdto);
		
		return memberDto;
	}

}
