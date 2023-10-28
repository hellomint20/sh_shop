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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.branch.BranchService;

@Controller
@RequestMapping("shop")
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
	
	@ResponseBody
	@RequestMapping(value = "branchRegister", method = RequestMethod.POST) //지점 DB 등록
	public String branchRegister(@RequestBody Map<String, Object> map) {
		String result ="";
		try {
			result = Integer.toString(bs.branchRegister(map));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "branchModify", method = RequestMethod.POST) //지점 DB 등록
	public String branchModify(@RequestBody Map<String, Object> map, HttpSession session) {
		System.out.println(map);
		System.out.println(session.getAttribute("shopNo").toString());
		map.put("shopNo", session.getAttribute("shopNo"));
		System.out.println(map);
		String result = "";
		try {
			result = Integer.toString(bs.branchModify(map));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@ResponseBody
	@PostMapping("branchDelete")
	public String branchDelete(@RequestBody String shopNo) {
		System.out.println("branchDelete "+shopNo);
		
		String result = "";
		try {
			result = Integer.toString(bs.branchDelete(shopNo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
}
