package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {

	// 게시판 리스트 가져오기
	ArrayList<BoardDto> selectList();

	// 게시글 1개 가져오기
	BoardDto selectOne(BoardDto bdto);

}
