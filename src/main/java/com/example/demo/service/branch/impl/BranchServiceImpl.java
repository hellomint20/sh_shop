package com.example.demo.service.branch.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ShShopDTO;
import com.example.demo.common.GetMessage;
import com.example.demo.mapper.BranchMapper;
import com.example.demo.service.branch.BranchService;

@Service
public class BranchServiceImpl implements BranchService{

	@Autowired
	BranchMapper mapper;
	
	String msg = ""; // alert
	String url = ""; // url
	
	public List<Map<String, Object>> branchList(){
		List<Map<String, Object>> map = mapper.branchList();
		return map;
	}
	
	public String branchRegister(Map<String, Object> map) {
		// 현재 날짜 구하기
        LocalDate now = LocalDate.now();
        // 포맷 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        // 포맷 적용
        String formatedNow = now.format(formatter);
        // 결과 출력
        System.out.println(formatedNow); //202310
        
        //☆지점번호 가져오기
        int shopNo = mapper.branchShopNo()+1;
        String newShopNo = formatedNow+String.format("%04d", shopNo);
        map.put("shopNo", newShopNo);

		int result = 0;
		result = mapper.branchRegister(map);
		
		if(result == 1) { //지점 등록 성공
			msg = "지점 등록 성공";
			url = "/shop/branchList";
		}else { //지점 등록 실패
			msg = "지점 등록 실패";
			url = "/shop/branchList"; ///??? 쓰던 내용으로 돌려야 하나?
		}
		return GetMessage.getMessage(msg, url);
	}
	public Map<String, Object> branchInfo(String shopNo){
		return mapper.branchInfo(shopNo);
	}
	public String branchModify(Map<String, Object> map) {
		int result = 0;
		result = mapper.branchModify(map);
		
		if(result == 1) { //지점 수정 성공
			msg = "지점 정보 수정 성공";
			url = "/shop/branchInfo";
		}else { //지점 수정 실패
			msg = "지점 정보 수정 실패";
			url = "/shop/branchInfo"; ///??? 쓰던 내용으로 돌려야 하나?
		}
		return GetMessage.getMessage(msg, url);
	}
}
