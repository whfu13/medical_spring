package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardDao {

	// 게시판 리스트 가져오기
	ArrayList<BoardDto> selectList(int startRow, int endRow, String category, String searchWord);

	// 게시글 총 개수 - 리스트,검색 포함
	int selectCount(String category, String searchWord);

}
