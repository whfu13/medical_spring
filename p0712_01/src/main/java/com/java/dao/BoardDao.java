package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper		// IOC 컨테이너 등록
public interface BoardDao {

	// 게시판 리스트 가져오기
	ArrayList<BoardDto> selectList();

}
