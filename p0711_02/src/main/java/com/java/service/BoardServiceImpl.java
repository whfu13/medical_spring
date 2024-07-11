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
	
	@Override
	public ArrayList<BoardDto> selectList() {
		
		// mybatis 연결해서 list 가져오기
		ArrayList<BoardDto> list = boardDao.selectList();
		
		return list;
	} // selectList

	@Override // 게시글 1개 가져오기
	public BoardDto selectOne(BoardDto bdto) {
		boardDao.updateBhit(bdto);
		BoardDto boardDto = boardDao.selectOne(bdto);
		return boardDto;
	}

}
