package com.java.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.LoanDao;
import com.java.dto.LoanDto;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired LoanDao loanDao;

	@Override // Loan 리스트 -region
	public ArrayList<LoanDto> selectLoan() {
		
		ArrayList<LoanDto> list = loanDao.selectLoan();
		
		return list;
	}

	@Override	// Loan 리스트 -period
	public ArrayList<LoanDto> selectLoan2() {
		
		ArrayList<LoanDto> list = loanDao.selectLoan2();
		
		return list;
	}

	

}
