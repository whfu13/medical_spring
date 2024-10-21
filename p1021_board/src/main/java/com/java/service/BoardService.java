package com.java.service;

import java.util.Map;

public interface BoardService {

	// 게시판 리스트 가져오기 - 리스트, 검색 포함
	Map<String, Object> selectList(int page, String category, String searchWord);

}
