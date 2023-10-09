package com.example.demo.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DTO.ShProductDTO;
import com.example.demo.service.ShopService;

@Controller
@RequestMapping("shop")
public class ProductController {
	
	@Autowired
	ShopService ss;

	@GetMapping("sell")
	public String sell() {
		return "shop/product/sell";
	}
	@GetMapping("productInfo")
	public String productInfo() {
		return "shop/product/productInfo";
	}
	@GetMapping("productRegister")
	public String productRegister() {
		return "shop/product/productRegister";
	}
	@PostMapping("productRegister")
	public void productRegister(ShProductDTO dto, HttpServletResponse res) throws Exception{
		System.out.println(dto.getItemName());
		System.out.println(dto.getItemPrice());
		System.out.println(dto.getItemDesc());
		System.out.println(dto.getItemCategory());
		System.out.println(dto.getItemState());
		
		String msg = ss.productRegister(dto);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
		
	}
}
