package com.example.demo.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DTO.ShShopDTO;
import com.example.demo.service.ShopService;

@Controller
@RequestMapping("shop")
public class InfoController {
	
	@Autowired
	ShopService ss;

	@GetMapping("branchInfo")
	public String branchInfo() {
		return "shop/info/branchInfo";
	}
	@GetMapping("memberInfo")
	public String memberInfo() {
		return "shop/info/memberInfo";
	}
	@GetMapping("branchRegister")
	public String branchRegister() {
		return "shop/info/branchRegister";
	}
	@PostMapping("branchRegister")
	public void branchRegister(ShShopDTO dto, HttpServletResponse res) {
		//String msg = ss.branchRegister(dto);
		//res.setContentType("text/html; charset=utf-8");
		//PrintWriter out = res.getWriter();
		//out.print(msg);
		System.out.println(dto.getShopName());
		System.out.println(dto.getShopTel());
		System.out.println(dto.getShopAddr());
		System.out.println(dto.getManagerName());
		System.out.println(dto.getManagerHp());
	}
}
