package com.example.demo.service.interceptor.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.interceptorMapper;
import com.example.demo.service.interceptor.interceptorService;

@Service
public class interceptorServiceImpl implements interceptorService{
	@Autowired
	interceptorMapper im;
	
	@Override
	public void insertInterId(Map<String, Object> map) {
		try {
			im.insertInterId(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertInter(Map<String, Object> map) {
		try {
			im.insertInter(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
