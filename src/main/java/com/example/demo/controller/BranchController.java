package com.example.demo.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DTO.ShShopDTO;
import com.example.demo.service.branch.BranchService;

@Controller
public class BranchController {
	@Autowired
	BranchService bs;

	@GetMapping("branchList") //지점 목록
	public String branchList(Model model) {
		List<Map<String, Object>> list = bs.branchList();
		model.addAttribute("list", list);
		return "shop/branch/branchList";
	}
	
	@GetMapping("branchInfo") //지점 정보
	public String branchInfo(HttpSession session, Model model) {
		model.addAttribute("branchInfo", bs.branchInfo(session.getAttribute("shopNo").toString()));
		return "shop/branch/branchInfo";
	}
	@GetMapping("branchRegister") //지점 등록
	public String branchRegister() {
		return "shop/branch/branchRegister";
	}
	@RequestMapping("branchRegister") //지점 DB 등록
	public void branchRegister(@RequestParam Map<String, Object> map, HttpServletResponse res) throws Exception {
		String msg = bs.branchRegister(map);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
	}

	@RequestMapping("branchModify") //지점 DB 등록
	public void branchModify(@RequestParam Map<String, Object> map, HttpServletResponse res) throws Exception {
		String msg = bs.branchModify(map);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
	}
	@PostMapping("branchDelete")
	public void branchDelete(@RequestBody String shopName) {
		System.out.println(shopName);
	}
}
