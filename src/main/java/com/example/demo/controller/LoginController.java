package com.example.demo.controller;

import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.login.LoginService;

@Controller
@RequestMapping("shop")
public class LoginController {
	
	@Autowired
	LoginService ls;
	
	@GetMapping("login") //로그인 페이지
	public String login() {
		return "shop/member/login";
	}
	/*@PostMapping("login_chk") //로그인 확인
	public void loginChk(@RequestParam String id, @RequestParam String pw,
							HttpServletResponse res, HttpSession session) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", pw);
		String msg = ls.loginChk(map, session);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
	}*/
	
	@ResponseBody //header 속성 대신 사용 //produces : 반환 타입 지정??
	@PostMapping(value = "login_chk")
	public String loginChk(@RequestBody Map<String, Object> map, HttpSession session) {
		System.out.println("loginChk "+ map);
		String result = "";
		result = ls.loginChk(map, session);
		System.out.println("확인"+result);
		return result;
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
