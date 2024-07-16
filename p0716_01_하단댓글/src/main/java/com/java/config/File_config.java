package com.java.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class File_config implements WebMvcConfigurer {
	
	// 이미지나 동영상, 파일 업로드 관련해서 다른 폴더를 연결할때 설정
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/upload/**")
		.addResourceLocations("file:///c:/upload/");
		
		registry.addResourceHandler("/uploadImages/**")
		.addResourceLocations("file:///c:/images/");
	}

}