package com.example.demo.service.member.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.common.GetMessage;
import com.example.demo.mapper.MemberMapper;
import com.example.demo.service.member.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper mapper;
	
	String msg = ""; // alert
	String url = ""; // url
	
	public List<Map<String, Object>> branchList(){ //지점 목록 가져오기
		return mapper.branchList();
	}
	public List<Map<String, Object>> authTypeList(){ //관리자 등급 가져오기
		return mapper.authTypeList();
	}
	
	public int register(Map<String, Object> map) { //회원가입
		
		//지점번호 가져오기
		Map<String, Object> shopNo = mapper.getShopNo(map.get("shopName").toString()); 
		System.out.println(shopNo);
		map.put("shopNo", shopNo.get("shop_no").toString());
		
		//관리자 등급 번호 가져오기
		List<Map<String, Object>> authType = mapper.authTypeList();
		for(int i=0; i<authType.size(); i++) {
			if(authType.get(i).get("code_desc1").equals(map.get("authType"))) {
				map.put("authType", authType.get(i).get("code_no"));
			}
		}
		
		System.out.println(map);
		int result = 0;
		
		try { //DB 넘어가는 
			 result = mapper.register(map);
		} catch (Exception e) {
			result = 99;
			e.printStackTrace();
		}
		return result;
	}

	public Map<String, Object> memberInfo(String id) { //개인정보 보여주기
		Map<String, Object> map = mapper.getInfo(id);
		map.put("shopName", mapper.getShopName(map.get("shop_no").toString()).get("shop_name"));
		return map;
	}
	
	public int memberModify(Map<String, Object> map) { //개인정보 수정
		Map<String, Object> shopNo = mapper.getShopNo(map.get("shopNo").toString()); //지점번호 가져오기
		map.put("shopNo", shopNo.get("shop_no"));
		
		System.out.println(map);
		
		int result = 0;
		result = mapper.memberModify(map);
		return result;
	}
	public String memberDelete(HttpSession session) { //회원 탈퇴
		int result = 0;
		result = mapper.memberDelete(session.getAttribute("memberId").toString());
		
		if(result == 1) { //수정 성공
			session.invalidate(); //세션 삭제
			msg = "탈퇴 되었습니다";
			url = "/";
		}else { //수정 실패
			msg = "문제 발생";
			url = "/shop/memberInfo";
		}
		return GetMessage.getMessage(msg, url);
	}
}
