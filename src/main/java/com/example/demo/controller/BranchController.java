package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.branch.BranchService;

@Controller
@RequestMapping("shop")
public class BranchController {
	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
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
	
	@PostMapping("/branchModi.page") //재고 수정 페이지
	public String branchModiPage(String shopNo, Model model){
		LOGGER.info("[ ::: shop/branchModi.page ::: ]");
		try {
			model.addAttribute("branch", bs.branchInfo(shopNo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "shop/branch/branchModiPage";
	}
	
	@PostMapping("/branchModi.do") //재고 수정 DB 등록
	public ModelAndView branchModiDo(@RequestBody Map<String, Object> map) {
		LOGGER.info("[ ::: shop/branchModi.do ::: ]");
		
		ModelAndView mav = new ModelAndView("jsonView");
		
		int result = 99;
		
		try {
			result = bs.branchModiDo(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("result", result);
		
		return mav;
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
