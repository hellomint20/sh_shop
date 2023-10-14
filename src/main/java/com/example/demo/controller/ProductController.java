package com.example.demo.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DTO.ShMemberDTO;
import com.example.demo.DTO.ShProductDTO;
import com.example.demo.common.GetMessage;
import com.example.demo.service.product.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService ps;

	@GetMapping("productAllList") //전체 재고 목록
	public String productAllList(Model model) {
		Map<String, Object> list = ps.productAllList();
		model.addAttribute("list", list);
		return "shop/product/productAllList";
	}
	
	@GetMapping("productList") //지점별 재고 목록
	public String productList(HttpSession session, Model model, HttpServletResponse res) throws Exception {
		System.out.println(session.getAttribute("shopNo"));
		Map<String, Object> stock = ps.productList(session.getAttribute("shopNo").toString());
		Map<String, Object> pro = ps.productgetList(stock.get("item_no").toString());
		model.addAttribute("stock", stock);
		model.addAttribute("pro", pro);
		return "shop/product/productList";
	}
	
	@GetMapping("productInfo") //재고 상세정보
	public String productInfo() {
		return "shop/product/productInfo";
	}
	@GetMapping("productRegister") //재고 등록
	public String productRegister() {
		return "shop/product/productRegister";
	}
	@PostMapping("productRegister") //재고 DB 등록
	public void productRegister(ShProductDTO dto, HttpServletResponse res) throws Exception{
		System.out.println(dto.getItemName());
		System.out.println(dto.getItemPrice());
		System.out.println(dto.getItemDesc());
		System.out.println(dto.getItemCategory());
		System.out.println(dto.getItemState());
		
		String msg = ps.productRegister(dto);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
	}
	
	@GetMapping("sellRefund") //재고 판매/환불
	public String sell() {
		return "shop/product/sellRefund";
	}
}
