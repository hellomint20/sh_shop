package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ShMemberDTO;
import com.example.demo.DTO.ShShopDTO;
import com.example.demo.mapper.ShopMapper;

@Service // @Component
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	ShopMapper mapper;
	
	String msg = ""; // alert
	String url = ""; // url

	Map<String, Object> aa = new HashMap<>();
	List<Map<String, Object>> aa1 = new ArrayList<>();
	
	public String loginChk(String id, String pw) {
//		ShopMemberDTO dto = mapper.getInfo(id);
		ShMemberDTO dto = null;

		if(dto == null) {
			if("1".equals(pw)) { //로그인 성공
				msg = "로그인 성공";
				url = "/shop/successLogin/"+id;
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
		return getMessage(msg, url);
	}
	public String logout() {
		msg = "로그아웃 되었습니다";
		url = "/shop/main";
		return getMessage(msg, url);
	}
	public String branchRegister(ShShopDTO dto) {
		//dto.setShopNo() //지점 번호 넣어주고 지점 번호까지 dto로 넘겨준다
		int result = 0;
		result = mapper.branchRegister(dto);
		
		if(result == 1) { //지점 등록 성공
			msg = "지점 등록 성공";
			url = "/shop/branchInfo";
		}else { //지점 등록 실패
			msg = "지점 등록 실패";
			url = "/shop/branchInfo"; ///??? 쓰던 내용으로 돌려야 하나?
		}
		return getMessage(msg, url);
	}
}
