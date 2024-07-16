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

	// 게시글 1개 가져오기 - 현재글,이전글,다음글
	BoardDto selectOne(BoardDto bdto);
	BoardDto selectOnePrev(BoardDto bdto);
	BoardDto selectOneNext(BoardDto bdto);

	// 조회수 1증가
	void updateBhit(BoardDto bdto);

	// 게시글 저장
	void insertBoard(BoardDto bdto);



}
