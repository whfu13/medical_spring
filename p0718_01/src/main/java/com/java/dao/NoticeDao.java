package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.NoticeDto;

@Mapper
public interface NoticeDao {

	// 게시판 리스트 가져오기
	ArrayList<NoticeDto> selectAll();

}
