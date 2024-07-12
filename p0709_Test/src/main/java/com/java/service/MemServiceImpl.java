package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.MemDto;
import com.java.mapper.MemMapper;
@Service
public class MemServiceImpl implements MemService {
	
	@Autowired
	MemMapper memMapper;

	@Override
	public MemDto selectLogin(MemDto mdto) {
		
		MemDto memDto = memMapper.selectLogin(mdto);
		
		return memDto;
	}


}
