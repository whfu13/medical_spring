package com.java.service;

import java.util.ArrayList;

import com.java.dto.NoticeDto;

public interface NoticeService {

	// 게시판 리스트 가져오기
	ArrayList<NoticeDto> selectAll();

}
