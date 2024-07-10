package com.java.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberDto;

@Mapper
public interface MemberMapper {

	static MemberDto selectLogin(MemberDto mdto) {
		return null;
	}

}
