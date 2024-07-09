package com.java.controller;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.Students;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class StuController {
	
	@RequestMapping("/students/students")
	public String students() {
		return "students/students";
	}
	@RequestMapping("/students/doStudents")
	public ModelAndView doStudents(Students stu) {
		
		stu.setTotal(stu.getKor()+stu.getEng()+stu.getMath());
		stu.setAvg(stu.getTotal()/3.0);
		stu.setHobby(Arrays.toString(stu.getHobbys()));
		
		System.out.println("국어 : "+stu.getKor());
		System.out.println("평균 : "+stu.getAvg());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("stu",stu);
		mv.setViewName("students/doStudents");
		
		return mv;
	}
	
	@RequestMapping("/students/stuUpdate")
	public ModelAndView stuUpdate(Students stu) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("stu",stu);
		mv.setViewName("students/stuUpdate");
		return mv;
		
	}
}
