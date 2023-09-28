package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ShMemberDTO;
import com.example.demo.mapper.ShopMapper;

@Service // @Component
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	ShopMapper mapper;

	Map<String, Object> aa = new HashMap<>();
	List<Map<String, Object>> aa1 = new ArrayList<>();
	
	public String loginChk(String id, String pw) {
//		ShopMemberDTO dto = mapper.loginChk(id);
		ShMemberDTO dto = null;

		String msg = ""; // 주석1
		String url = ""; // 주석2
		
		if(dto == null) {
			if("1".equals(pw)) { //로그인 성공
				msg = "로그인 성공";
				url = "/shop/successLogin";
			}else { //비밀번호 틀립
				msg = "비밀번호가 틀림";
				url = "/shop/login";
			}
		}else { //아이디가 없음
			msg = "존재하는 아이디가 없음";
			url = "/shop/login";
		}
		
		return getMessage(msg, url);
	}
	
	public String getMessage(String msg, String url) {
		String message = "<script>alert('"+msg+"');";
		message += "location.href='"+url+"';</script>";
		return message;
	}
}
