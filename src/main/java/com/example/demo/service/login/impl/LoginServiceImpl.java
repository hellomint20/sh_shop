package com.example.demo.service.login.impl;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.common.GetMessage;
import com.example.demo.mapper.MemberMapper;
import com.example.demo.service.login.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	MemberMapper mapper;
	
	String msg = ""; // alert
	String url = ""; // url
	
	public String loginChk(Map<String, Object> map, HttpSession session) {
		Map<String, Object> mapInfo = mapper.getInfo(map.get("id").toString());
		
		String result = "99";
		
		if(mapInfo != null) {
			if(mapInfo.get("member_pw").equals(map.get("pw"))) { //로그인 성공
				session.setAttribute("memberId", mapInfo.get("member_id"));
				session.setAttribute("authType", mapInfo.get("auth_type"));
				session.setAttribute("memberName", mapInfo.get("member_name"));
				session.setAttribute("shopNo", mapInfo.get("shop_no"));
				result = "1";
				System.out.println(session.getAttribute("shopNo"));
			}else { //비밀번호 틀립
				result = "2";
			}
		}else { //아이디가 없음
			result = "0";
		}
		
		return result;
	}
	public String logout() {
		msg = "로그아웃 되었습니다";
		url = "/";
		return GetMessage.getMessage(msg, url);
	}
}
