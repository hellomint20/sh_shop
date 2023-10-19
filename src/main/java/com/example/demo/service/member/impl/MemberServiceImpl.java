package com.example.demo.service.member.impl;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ShMemberDTO;
import com.example.demo.common.GetMessage;
import com.example.demo.mapper.BranchMapper;
import com.example.demo.mapper.MemberMapper;
import com.example.demo.service.member.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper mapper;
	
	String msg = ""; // alert
	String url = ""; // url
	
	public String register(ShMemberDTO dto) {
		Map<String, Object> map = mapper.getShopNo(dto.getShopNo());
		dto.setShopNo(map.get("shop_no").toString()); //DB에 지점번호 등록
		
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
	
	public String register2(Map<String, Object> map) {
		System.out.println(map);
		Map<String, Object> shopNo = mapper.getShopNo(map.get("shopName").toString());
		System.out.println(shopNo);
		map.put("shopNo", shopNo.get("shop_no").toString());
		System.out.println(map);
		int result = 0;
		result = mapper.register2(map);
		
		if(result == 1) { //회원가입 성공
			msg = "회원가입 성공";
			url = "/shop/login";
		}else { //회원가입 실패
			msg = "회원가입 실패";
			url = "/shop/login";
		}
		return GetMessage.getMessage(msg, url);
	}

	public Map<String, Object> memberInfo(String id) {
		Map<String, Object> map = mapper.getInfo(id);
		map.put("shopName", mapper.getShopName(map.get("shop_no").toString()).get("shop_name"));
		return map;
	}
	
	public String memberModify(ShMemberDTO dto) {
		Map<String, Object> map = mapper.getShopNo(dto.getShopNo());
		dto.setShopNo(map.get("shop_no").toString()); //지점번호 가져오기
		
		int result = 0;
		result = mapper.memberModify(dto);
		
		if(result == 1) { //수정 성공
			msg = "개인정보가 수정 되었습니다";
			url = "/shop/memberInfo";
		}else { //수정 실패
			msg = "문제 발생";
			url = "/shop/memberInfo";
		}
		return GetMessage.getMessage(msg, url);
	}
	public String memberDelete(HttpSession session) { //회원 탈퇴
		int result = 0;
		result = mapper.memberDelete(session.getAttribute("memberId").toString());
		
		if(result == 1) { //수정 성공
			session.invalidate(); //세션 삭제
			msg = "탈퇴 되었습니다";
			url = "/shop";
		}else { //수정 실패
			msg = "문제 발생";
			url = "/shop/memberInfo";
		}
		return GetMessage.getMessage(msg, url);
	}
}
