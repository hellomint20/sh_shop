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
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.service.member.MemberService;

@Controller
@RequestMapping("shop")
public class MemberController {
	
	@Autowired
	MemberService ms;
	
	@GetMapping("register/page") //회원가입 페이지
	public String register(Model model) {
		model.addAttribute("branch", ms.branchList()); //현재 지점 목록 가져오기
		List<Map<String, Object>> authType = ms.authTypeList();
		authType.remove(0); //관리자 등급 제외
		model.addAttribute("authType", authType );//관리자 등급 가져오기
		return "shop/member/memberRegister";
	}
	@ResponseBody
	@RequestMapping(value ="register/do", method = RequestMethod.POST)
	public String register(@RequestBody Map<String, Object> map){
		System.out.println(map); //{memberId=4, memberPw=4, memberName=김현웅, shopName=서울, authType=매니저}
		String result = "";
		try {
			result = Integer.toString(ms.register(map));
		} catch (Exception e) {
			System.out.println("con");
			e.printStackTrace();
		}
		System.out.println("확인"+result);
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
		System.out.println(map);
		String result = "";
		try {
			result = Integer.toString(ms.memberModify(map));
		} catch (Exception e) {
			System.out.println("con");
			e.printStackTrace();
		}
		System.out.println("확인"+result);
		
		return result;
	}
	@GetMapping("memberDelete") //회원 탈퇴
	public void memberDelete(HttpSession session, HttpServletResponse res) throws Exception {
		String msg = ms.memberDelete(session);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
	}
}
