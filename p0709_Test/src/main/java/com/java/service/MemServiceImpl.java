package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.dto.MemDto;
import com.java.mapper.MemMapper;

public class MemServiceImpl implements MemService {
	
	@Autowired
	MemMapper memMapper;

	@Override
	public MemDto selectLogin(MemDto mdto) {
		
		MemDto mdto = memMapper.selectLogin(mdto);
		
		return mdto;
	}

}
