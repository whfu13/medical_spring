package com.java.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.service.BoardService;

@Controller
public class BoardController {

	@Autowired BoardService boardService;
	
	@RequestMapping("/board/list") // 게시판 페이지
	public ModelAndView list(@RequestParam(defaultValue = "1")int page,
			String category, String searchWord) {
		
		// 리스트, 검색 포함
		Map<String, Object> map = boardService.selectList(page,category,searchWord);
		ModelAndView mv = new ModelAndView();
		mv.addObject("map",map);
		mv.setViewName("/board/list");
		return mv;
	}
}
