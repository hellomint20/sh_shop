package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.service.member.MemberService;

@Controller
@RequestMapping("shop")
public class MemberController {
	
	@Autowired
	MemberService ms;
	
	@GetMapping("register/page") //회원가입 페이지
	public String register(Model model) {
		model.addAttribute("branch", ms.branchList()); //지점 목록 가져오기
		model.addAttribute("authType", ms.authTypeList());//관리자 등급 가져오기
		return "shop/member/memberRegister";
	}
	
	@ResponseBody
	@RequestMapping(value ="register/do", method = RequestMethod.POST)
	public String register(@RequestBody Map<String, Object> map){
		String result = "";
		try {
			result = Integer.toString(ms.register(map));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@GetMapping("memberInfo") //회원 개인 정보
	public String memberInfo(HttpSession session, Model model) {
		Map<String, Object> map = ms.memberInfo(session.getAttribute("memberId").toString());
		model.addAttribute("dto", map);
		return "shop/member/memberInfo";
	}
	
	@ResponseBody
	@PostMapping("memberModify") //회원 개인 정보 수정 DB 등록
	public String memberModify(@RequestBody Map<String, Object> map)  {
		String result = "";
		try {
			result = Integer.toString(ms.memberModify(map));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@ResponseBody
	@PostMapping("memberDelete") //회원 탈퇴
	public String memberDelete(@RequestBody String id) {
		System.out.println("con "+id);
		String result = "";
		try {
			result = Integer.toString(ms.memberDelete(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@GetMapping("memberList") //직원 리스트
	public String memberList(Model model) {
		List<Map<String, Object>> map = ms.memberList();
		model.addAttribute("list", map);
		return "shop/member/memberList";
	}
}
