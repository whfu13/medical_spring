package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.DepDao;
import com.java.dto.DepDto;

@Service
public class DepServiceImpl implements DepService {

	@Autowired
	DepDao depDao;
	
	@Override
	public ArrayList<DepDto> selectAll() {
		ArrayList<DepDto> list = depDao.selectAll();
		return list;
	}

}
