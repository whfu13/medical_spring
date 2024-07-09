package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Sample {
	
	private String name;
	private String id;
	private String pw1;
	private String pw2;
	private String email;
	private int address;
	private String phone;
	
	public Sample() {}
	
	public Sample(String name, String id, String pw1, String pw2, String email, int address, String phone) {
		this.name = name;
		this.id = id;
		this.pw1 = pw1;
		this.pw2 = pw2;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}
	
	
}
