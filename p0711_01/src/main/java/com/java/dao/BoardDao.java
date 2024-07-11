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
	
	// 게시글 저장
	void insertBoard(BoardDto bdto);
	
	// 게시글 삭제
	void deleteBoard(BoardDto bdto);

	// 게시글 수정 저장
	void updateBoard(BoardDto bdto);
	
	// 답글 페이지 저장
	void insertReply(BoardDto bdto);

	// step 1씩 증가
	void updateBstep(BoardDto bdto);
	

}
