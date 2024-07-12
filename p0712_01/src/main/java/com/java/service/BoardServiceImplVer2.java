package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;

@Service
@Qualifier(value="ver2")
public class BoardServiceImplVer2 implements BoardService {

	// 새로운 버전의 서비스를 1개 더 만듬.
	
	@Override
	public void SelectCount() {
		System.out.println("BoardServiceImpl 버전22222이 실행됩니다.");
	}

	@Override
	public ArrayList<BoardDto> selectList() {
		return null;
	}
	
}
