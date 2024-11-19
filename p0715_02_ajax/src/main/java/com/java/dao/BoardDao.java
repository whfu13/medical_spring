package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardDao {

	// 게시글 리스트 불러오기
	ArrayList<BoardDto> selectAll(String category,String sword);

}
