package com.java.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class BoardController {

	@Autowired BoardService boardService;
//	}
	@RequestMapping("/board/list")	// 게시판 페이지
	public ModelAndView list(@RequestParam(defaultValue = "1")int page,
			String category, String sWord) {
		
		Map<String, Object> map = boardService.selectAll(page,category,sWord);
		ModelAndView mv = new ModelAndView();
		mv.addObject("map",map);
		mv.setViewName("board/list");
		
		return mv;
	}// list
	
	@RequestMapping("/board/view")	// 뷰페이지
	public ModelAndView view(BoardDto bdto,@RequestParam(defaultValue = "1")int page) {
		
		Map<String, Object> map = boardService.selectOne(bdto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("map",map);
		mv.setViewName("board/view");
		
		return mv;
		
	}// view
	
	@GetMapping("/board/write") // 글쓰기화면
	public String write() {
		return "board/write";
	}// write
	
	@PostMapping("/board/write") //글쓰기 저장
	public String write(BoardDto bdto,@RequestPart MultipartFile files) {
		String uFile="";
		//파일이 존재할 시
		if(!files.isEmpty()) {
			//jsp
			long time = System.currentTimeMillis();
			System.out.println("time : "+time);
			
			uFile = String.format("%d_%s", time,files.getOriginalFilename());
			String saveUrl = "c:/upload/";
			File f = new File(saveUrl+uFile);
			try {
				files.transferTo(f);
			} catch (Exception e) {	e.printStackTrace();} //파일업로드
		}//if
		
		//변경된 파일이름 저장
		bdto.setBfile(uFile);
		
		boardService.insertBoard(bdto);
		
		return "redirect:/board/list";
	}// write
	



}



