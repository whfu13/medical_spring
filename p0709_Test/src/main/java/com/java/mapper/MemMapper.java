package com.java.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemDto;

@Mapper
public interface MemMapper {
	
	MemDto seleccLogin(MemDto mdto);

}
