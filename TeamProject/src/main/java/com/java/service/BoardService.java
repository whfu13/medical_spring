package com.java.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

public interface BoardService {
	
	// 게시판 불러오기
	Map<String, Object> selectAll(int page, String category, String sWord);

	// 게시글 불러오기
	Map<String, Object> selectOne(BoardDto bdto);

	// 게시글 저장
	void insertBoard(BoardDto bdto);

}
