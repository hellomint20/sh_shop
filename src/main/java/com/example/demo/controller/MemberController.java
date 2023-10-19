package com.example.demo.controller;

import java.io.PrintWriter;
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
import com.example.demo.service.member.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService ms;
	
	@GetMapping("register") //회원가입 페이지
	public String register() {
		return "shop/member/memberRegister";
	}
	@RequestMapping("register")
	public void register(@RequestParam Map<String, Object> map, HttpServletResponse res) throws Exception {
		String msg = ms.register2(map);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
	}
//	@PostMapping("register") //회원가입 DB 등록
//	public void register(ShMemberDTO dto, HttpServletResponse res) throws Exception {
//		String msg = ms.register(dto);
//		res.setContentType("text/html; charset=utf-8");
//		PrintWriter out = res.getWriter();
//		out.print(msg);
//	}

	@GetMapping("memberInfo") //회원 개인 정보
	public String memberInfo(HttpSession session, Model model) {
		Map<String, Object> map = ms.memberInfo(session.getAttribute("memberId").toString());
		model.addAttribute("dto", map);
		return "shop/member/memberInfo";
	}

	@PostMapping("memberModify") //회원 개인 정보 수정 DB 등록
	public void memberModify(ShMemberDTO dto, HttpServletResponse res) throws Exception {
		String msg = ms.memberModify(dto);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
	}
	@GetMapping("memberDelete") //회원 탈퇴
	public void memberDelete(HttpSession session, HttpServletResponse res) throws Exception {
		String msg = ms.memberDelete(session);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
	}
}
