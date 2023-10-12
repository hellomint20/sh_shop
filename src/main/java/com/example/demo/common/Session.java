package com.example.demo.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.demo.DTO.ShMemberDTO;

public class Session {
	public static Map<String, Object> loginsession(ShMemberDTO dto ){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", dto.getMemberId());
		map.put("memberPw", dto.getMemberPw()); //비밀번호까지 필요가 있나
		map.put("shopNo", dto.getShopNo());
		map.put("authType", dto.getAuthType());
		map.put("memberName", dto.getMemberName());
		return map;
	}
}
//session.setAttribute(LoginSession.LOGIN, id );