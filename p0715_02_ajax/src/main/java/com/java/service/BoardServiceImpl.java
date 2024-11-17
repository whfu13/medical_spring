package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardDao;
import com.java.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boardDao;

	@Override	// 게시글 리스트 불러오기
	public ArrayList<BoardDto> selectAll(String category, String sword) {
		
		ArrayList<BoardDto> list = boardDao.selectAll(category, sword);
		
		return list;
	}

	
	
}
