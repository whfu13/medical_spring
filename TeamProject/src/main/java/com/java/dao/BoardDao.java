package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardDao {

	// 게시판 불러오기
	ArrayList<BoardDto> selectAll(int startRow, int endRow, String category, String sWord);

	// 게시글 개수
	int selectCount(String category, String sWord);
	
	// 게시글 가져오기(현재글,이전글,다음글)
	BoardDto selectOne(BoardDto bdto);
	BoardDto selectOnePrev(BoardDto bdto);
	BoardDto selectOneNext(BoardDto bdto);

	// 조회수 증가
	void updateBhit(BoardDto bdto);
	
	// 게시글 저장
	void insertBoard(BoardDto bdto);



}
