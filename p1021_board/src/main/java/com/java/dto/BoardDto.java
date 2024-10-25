package com.java.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {

	private int post_no;
	private String id;
	private String post_title;
	private String post_content;
	private int post_group;
	private int post_step;
	private int post_indent;
	private int post_hit;
	private Timestamp post_reg_date;
	private String post_file;
	private Boolean is_notice;
}
