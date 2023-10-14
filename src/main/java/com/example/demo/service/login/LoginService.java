package com.example.demo.service.login;

import java.util.Map;

import javax.servlet.http.HttpSession;

public interface LoginService {
	public String loginChk(Map<String, Object> map, HttpSession session);
	public String logout();
}
