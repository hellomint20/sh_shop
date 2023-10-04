package com.example.demo.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DTO.ShMemberDTO;
import com.example.demo.common.LoginSession;
import com.example.demo.service.ShopService;

@Controller
@RequestMapping("shop")
public class LoginController {
	
	@Autowired 
	ShopService ss;
	
	@GetMapping("login") //로그인 페이지
	public String login() {
		return "shop/login/login";
	}
	@PostMapping("login_chk") //로그인 확인
	public void loginChk(@RequestParam String id, @RequestParam String pw,
							HttpServletResponse res) throws Exception{
		String msg = ss.loginChk(id, pw);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
	}
	@GetMapping("successLogin/{id}") //로그인 성공했을 경우, 세션 생성
	public String successLogin(HttpSession session, @PathVariable String id) {
		System.out.println("successLogin : "+LoginSession.LOGIN);
		session.setAttribute(LoginSession.LOGIN, id );
		return "redirect:/shop/main";
	}
	@GetMapping("register") //회원가입 페이지
	public String register() {
		return "shop/login/register";
	}
	@PostMapping("register") //회원가입 했을 때
	public void register(ShMemberDTO dto, HttpServletResponse res) throws Exception {
		String msg = ss.register(dto);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
		System.out.println(dto.getMemberId());
		System.out.println(dto.getMemberPw());
		System.out.println(dto.getMemberName());
		System.out.println(dto.getShopNo());
		System.out.println(dto.getAuthType());
	}
	@GetMapping("logout")
	public void logout(HttpSession session, HttpServletResponse res) throws Exception{
		session.invalidate();
		String msg = ss.logout();
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
	}
}
