package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/board/list") // 게시판 페이지
	public ModelAndView list() {
		
		ArrayList<BoardDto> list = boardService.selectList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
		mv.setViewName("board/list");
		return mv;
	
	}// list
	
	@RequestMapping("/board/view") // 뷰페이지
	public ModelAndView view(BoardDto bdto) {
		
		BoardDto boardDto = boardService.selectOne(bdto);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardDto",boardDto);
		mv.setViewName("board/view");
		
		return mv;
		
	}// view
	
//	public String write() {
//		return("board/write_view");
//	}
	
}
