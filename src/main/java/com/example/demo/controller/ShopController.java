package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.ShopService;

@Controller
@RequestMapping("shop")
public class ShopController {
	
	@Autowired
	ShopService ss;

	@GetMapping("main")
	public String main() {
		return "shop/main";
	}
	@GetMapping("salesStatus")
	public String salesStatus() {
		return "shop/salesStatus";
	}
	@GetMapping("inventoryStatus")
	public String inventoryStatus() {
		return "shop/inventoryStatus";
	}
	@GetMapping("test")
	public String test() {
		return "shop/test";
	}
}
