package com.example.demo.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.ShopService;
import com.example.demo.service.ShopServiceImpl;

@Controller
@RequestMapping("shop")
public class ShopController {
	
	@Autowired
	ShopService ss;
	
//	@Autowired
//	ShopService ss;
//	
//	@Autowired
//	ShopService ss;
	
//	public ShopController() {
//		System.out.println("shop con 실행");
//	}
	@GetMapping("main")
	public String main() {
		return "shop/main";
	}
	@GetMapping("login")
	public String login() {
		return "shop/login";
	}
	@PostMapping("login_chk")
	public void loginChk(@RequestParam String id, @RequestParam String pw,
							HttpServletResponse res) throws Exception{
		System.out.println("id : "+id);
		System.out.println("pw : "+pw);
		String msg = ss.loginChk(id, pw);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
	}
	@GetMapping("successLogin")
	public String successLogin() {
		return "shop/successLogin";
	}
	@GetMapping("branchInfo")
	public String branchInfo() {
		return "shop/branchInfo";
	}
	@GetMapping("memberInfo")
	public String memberInfo() {
		return "shop/memberInfo";
	}
	@GetMapping("sell")
	public String sell() {
		return "shop/sell";
	}
	@PostMapping("sell")
	public void sell(@RequestParam String sellprocess) {
		System.out.println("con sell 값 : "+sellprocess);
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
