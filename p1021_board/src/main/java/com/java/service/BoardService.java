package com.java.service;

import java.util.List;
import java.util.Map;

import com.java.dto.BoardDto;

public interface BoardService {

	// 게시판 리스트 가져오기 - 리스트, 검색 포함
	Map<String, Object> selectList(int page, String category, String searchWord);

	// 게시글 1개 가져오기
	Map<String, Object> selectOne(BoardDto bdto);

	// 게시글 저장
	void insertPost(BoardDto bdto);

	// 게시글 삭제
	void deletePost(BoardDto bdto);

	// 게시글 수정
	BoardDto updatePost(BoardDto bdto);

	// 게시글 수정 저장
	void doUpdatePost(BoardDto bdto);

	// 공지사항 가져오기
	List<BoardDto> selectNoticeList();

}
