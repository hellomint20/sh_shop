package com.example.demo.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DTO.ShShopDTO;
import com.example.demo.service.branch.BranchService;

@Controller
public class BranchController {
	@Autowired
	BranchService bs;

	@GetMapping("branchList") //지점 목록
	public String branchList() {
		return "shop/branch/branchList";
	}
	
	@GetMapping("branchInfo") //지점 정보
	public String branchInfo() {
		return "shop/branch/branchInfo";
	}
	@GetMapping("branchRegister") //지점 등록
	public String branchRegister() {
		return "shop/branch/branchRegister";
	}
	@PostMapping("branchRegister") //지점 DB 등록
	public void branchRegister(ShShopDTO dto, HttpServletResponse res) throws Exception {
		String msg = bs.branchRegister(dto);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
		System.out.println(dto.getShopName());
		System.out.println(dto.getShopTel());
		System.out.println(dto.getShopAddr());
		System.out.println(dto.getManagerName());
		System.out.println(dto.getManagerHp());
	}
}
