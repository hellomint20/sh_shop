package com.example.demo.controller;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	private final Logger LOGGER = LoggerFactory.getLogger(CommonController.class);

	@RequestMapping("/")
	public String main() {
		LOGGER.info("--- main ---");
		return "shop/main";
	}
}
