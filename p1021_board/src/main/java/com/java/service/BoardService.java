package com.java.service;

import java.util.Map;

import com.java.dto.BoardDto;

public interface BoardService {

	// 게시판 리스트 가져오기 - 리스트, 검색 포함
	Map<String, Object> selectList(int page, String category, String searchWord);

	// 게시글 1개 가져오기
	Map<String, Object> selectOne(BoardDto bdto);

}
