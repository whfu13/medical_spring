package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {

	void SelectCount();

	ArrayList<BoardDto> selectList();

}
