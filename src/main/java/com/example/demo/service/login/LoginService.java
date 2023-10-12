package com.example.demo.service.login;

import com.example.demo.DTO.ShMemberDTO;

public interface LoginService {
	public String loginChk(String id, String pw);
	public String register(ShMemberDTO dto);
	public String logout();
}
