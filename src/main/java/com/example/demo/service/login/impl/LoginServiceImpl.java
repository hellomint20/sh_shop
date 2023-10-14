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
		if(mapInfo != null) {
			if(mapInfo.get("member_pw").equals(map.get("pw"))) { //로그인 성공
				session.setAttribute("memberId", mapInfo.get("member_id"));
				session.setAttribute("authType", mapInfo.get("auth_type"));
				session.setAttribute("memberName", mapInfo.get("member_name"));
				session.setAttribute("shopNo", mapInfo.get("shop_no"));
				msg = "로그인 성공";
				url = "/shop/";
			}else { //비밀번호 틀립
				msg = "비밀번호가 틀림";
				url = "/shop/login";
			}
		}else { //아이디가 없음
			msg = "존재하는 아이디가 없음";
			url = "/shop/login";
		}
		
		return GetMessage.getMessage(msg, url);
	}
	public String logout() {
		msg = "로그아웃 되었습니다";
		url = "/shop/";
		return GetMessage.getMessage(msg, url);
	}
}
