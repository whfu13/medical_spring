package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardDao {

	// 게시판 리스트 가져오기
	ArrayList<BoardDto> selectList();

	// 게시글 1개 가져오기
	BoardDto selectOne(BoardDto bdto);
	
	// 조회수 1증가
	void updateBhit(BoardDto bdto);

}
