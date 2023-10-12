package com.example.demo.service.login.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ShMemberDTO;
import com.example.demo.common.GetMessage;
import com.example.demo.common.Session;
import com.example.demo.mapper.MemberMapper;
import com.example.demo.service.login.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	MemberMapper mapper;
	
	String msg = ""; // alert
	String url = ""; // url
	
	public String loginChk(String id, String pw) {
		ShMemberDTO dto = mapper.getInfo(id);

		if(dto != null) {
			if(dto.getMemberPw().equals(pw)) { //로그인 성공
				Map<String, Object> map = Session.loginsession(dto);
				System.out.println("service"+map);
				msg = "로그인 성공";
				//url = "/shop/successLogin/"+id;
				url = "/shop/successLogin/"+map;
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
	public String register(ShMemberDTO dto) {
		int result = 0;
		result = mapper.register(dto);
		
		if(result == 1) { //회원가입 성공
			msg = "회원가입 성공";
			url = "/shop/login";
		}else { //회원가입 실패
			msg = "회원가입 실패";
			url = "/shop/login";
		}
		return GetMessage.getMessage(msg, url);
	}
	public String logout() {
		msg = "로그아웃 되었습니다";
		url = "/shop/main";
		return GetMessage.getMessage(msg, url);
	}
}
