package com.example.demo.controller;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.testDB;

@Controller
public class CommonController {
	@Autowired
	testDB t;

	private final Logger LOGGER = LoggerFactory.getLogger(CommonController.class);

	@RequestMapping("/")
	public String main() {
		LOGGER.info("--- main ---");
		return "shop/main";
	}
	
	@RequestMapping("/test")
	public String test() {
		t.insertDB();
		return "shop/main";
	}
}
