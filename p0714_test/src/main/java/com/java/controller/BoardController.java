package com.java.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/board/list") // 게시판 페이지
	public ModelAndView list(@RequestParam(defaultValue ="1")int page,
			String category, String searchWord) {
		
		// 리스트,검색 포함
		Map<String, Object> map = boardService.selectList(page,category,searchWord);
		ModelAndView mv = new ModelAndView();
		mv.addObject("map",map);
		mv.setViewName("/board/list");
		return mv;
	}// list
	
	@RequestMapping("/board/view") // 뷰페이지
	public ModelAndView view(BoardDto bdto,@RequestParam(defaultValue = "1") int page) {
		
		// 현재글,이전글,다음글
		Map<String, Object> map = boardService.selectOne(bdto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("map",map);
		mv.addObject("page",page);
		mv.setViewName("board/view");
		return mv;
	}// view
	
	@RequestMapping("/board/write") // 글쓰기화면
	public String write() {
		return "board/write";
	} // write1
	
	@PostMapping("/board/write") //글쓰기 저장
	public String write(BoardDto bdto,@RequestPart MultipartFile files) {
		//id,btitle,bcontent,files
		System.out.println("controller files : "+files.getOriginalFilename());
		String uFile="";
		//파일이 존재할 시
		if(!files.isEmpty()) {
			//jsp
			long time = System.currentTimeMillis();
			System.out.println("time : "+time);
			
			//uuid방식
//			UUID uuid = UUID.randomUUID();
//			System.out.println("uuid : "+uuid);
			
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
	}// write2
	
	@RequestMapping("/board/delete") // 게시글 삭제
	public String delete(BoardDto bdto) {
		boardService.deleteBoard(bdto);
		return "redirect:/board/list";
	}
	
	
	
}