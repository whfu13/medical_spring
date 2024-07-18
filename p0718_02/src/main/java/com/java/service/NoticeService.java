package com.java.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.NoticeDto;

public interface NoticeService {

	// notice 리스트
	ArrayList<NoticeDto> selectAll();

}
