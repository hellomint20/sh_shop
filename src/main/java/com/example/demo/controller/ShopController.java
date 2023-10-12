package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("shop")
public class ShopController {
	
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
}
