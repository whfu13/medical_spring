package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SampleDto {
	
	private String name;
	private String id;
	private String pw1;
	private String pw2;
	private String email;
	private int address;
	private String phone;
	
	
}
