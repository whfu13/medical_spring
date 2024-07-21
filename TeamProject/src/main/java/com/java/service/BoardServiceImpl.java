package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardDao;
import com.java.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardDao boardDao;
	
	@Override	// 게시판 불러오기
	public Map<String, Object> selectAll(int page, String category, String sWord) {

		// --------------하단넘버링-----------------------------
		int countPerPage = 10; // 1페이지당 게시글 수
		int bottomPerNum = 10; // 하단넘버링 개수
		int countAll = boardDao.selectCount(category,sWord); // 게시글 총 개수
		
		// 최대페이지
		int maxPage = (int) Math.ceil((double)countAll/countPerPage);
		int startPage = ((page-1)/bottomPerNum)*bottomPerNum+1;
		int endPage = (startPage+bottomPerNum)-1;
		
		// 마지막 넘버링이 최대페이지 숫자보다 크면
		if(endPage>maxPage) endPage = maxPage;
		
		// 게시글 페이지에서 가져올 게시글 번호
		int startRow = (page-1)*countPerPage+1;
		int endRow = startRow+countPerPage+1;
		// --------------하단넘버링-----------------------------
		
		//mybatis연결해서 list 가져오기 - 게시글, 검색 포함
		ArrayList<BoardDto> list = boardDao.selectAll(startRow,endRow,category,sWord);
		
		Map<String, Object> map = new HashMap<>();
		map.put("list",list);
		map.put("countAll",countAll);
		map.put("startPage",startPage);
		map.put("endPage",endPage);
		map.put("maxPage",maxPage);
		map.put("page",page);
		map.put("category",category);
		map.put("searchWord",sWord);
		return map;
		
	}// selectAll

	@Override	// 게시글 불러오기
	public Map<String, Object> selectOne(BoardDto bdto) {
		boardDao.updateBhit(bdto); // 조회수 증가
		BoardDto boardDto = boardDao.selectOne(bdto);
		BoardDto prevDto = boardDao.selectOnePrev(bdto);
		BoardDto nextDto = boardDao.selectOneNext(bdto);
		
		Map<String, Object> map = new HashMap<>();
		map.put("boardDto", boardDto);
		map.put("prevDto", prevDto);
		map.put("nextDto", nextDto);
		return map;
		
	}// selectOne

	@Override	// 게시글 저장
	public void insertBoard(BoardDto bdto) {
		boardDao.insertBoard(bdto);
	}// insertBoard

}
