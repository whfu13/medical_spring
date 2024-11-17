package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {

	// 게시글 리스트 불러오기
	ArrayList<BoardDto> selectAll(String category,String sword);

}
