package com.example.demo.controller;

import org.slf4j.LoggerFactory;

import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.product.ProductService;

@Controller
public class CommonController {

	private final Logger LOGGER = LoggerFactory.getLogger(CommonController.class);

	@RequestMapping("/")
	public String main() {
		LOGGER.info("--- main ---");
		return "shop/main";
	}
}
