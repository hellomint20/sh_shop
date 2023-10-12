package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DTO.ShMemberDTO;
import com.example.demo.service.member.MemberService;

@Controller
@RequestMapping("shop")
public class MemberController {
	
	@Autowired
	MemberService ms;

	@GetMapping("memberInfo")
	public String memberInfo(HttpSession session, Model model) {
		ShMemberDTO dto = ms.memberInfo(session.getAttribute("userId").toString());
		model.addAttribute("dto", dto); 
		System.out.println("memberinfo "+dto);
		return "shop/info/memberInfo";
	}
}
