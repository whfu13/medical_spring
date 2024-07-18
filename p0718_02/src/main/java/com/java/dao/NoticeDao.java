package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.NoticeDto;

@Mapper
public interface NoticeDao {

	// notice 리스트
	ArrayList<NoticeDto> selectAll();

}
