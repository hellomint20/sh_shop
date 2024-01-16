package com.example.demo.service.member.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.PrintJobAttribute;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(rollbackForClassName = {})
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
				
		int result = 0;
		result = mapper.memberModify(map);
		return result;
	}
	public int memberDelete(String id) { //회원 삭제
		int result = 0;
		try {		
			result = mapper.memberDelete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Map<String, Object>> memberList(){ //직원 리스트
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			list = mapper.memberList();
		} catch (Exception e) {
			e.printStackTrace();		
			}
		return list;
	}
}
