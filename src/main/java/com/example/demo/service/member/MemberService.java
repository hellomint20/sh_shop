package com.example.demo.service.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.demo.DTO.ShMemberDTO;

public interface MemberService {
	public String register(ShMemberDTO dto);
	public String register2(Map<String, Object> map);
	public Map<String, Object> memberInfo(String id);
	public String memberModify(ShMemberDTO dto);
	public String memberDelete(HttpSession session);
}
