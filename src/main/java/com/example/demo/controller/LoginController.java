package com.example.demo.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.login.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService ls;
	
	@GetMapping("login") //로그인 페이지
	public String login() {
		return "shop/member/login";
	}
	@PostMapping("login_chk") //로그인 확인
	public void loginChk(@RequestParam String id, @RequestParam String pw,
							HttpServletResponse res, HttpSession session) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", pw);
		String msg = ls.loginChk(map, session);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
	}

	@GetMapping("logout")
	public void logout(HttpSession session, HttpServletResponse res) throws Exception{
		session.invalidate();
		String msg = ls.logout();
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
	}
}
