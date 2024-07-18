package com.java.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.LoanDto;

@Mapper
public interface LoanDao {

	ArrayList<LoanDto> selectLoan();

	ArrayList<LoanDto> selectLoan2();


}
