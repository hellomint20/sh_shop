package com.example.demo.service.branch.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.common.GetMessage;
import com.example.demo.mapper.BranchMapper;
import com.example.demo.service.branch.BranchService;

@Service
public class BranchServiceImpl implements BranchService{

	@Autowired
	BranchMapper mapper;
	
	String msg = ""; // alert
	String url = ""; // url
	
	public List<Map<String, Object>> branchList(){ //지점 목록 조회
		List<Map<String, Object>> map = mapper.branchList();
		return map;
	}
	
	public int branchRegister(Map<String, Object> map) { //지점 등록
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

		return result;
	}
	public Map<String, Object> branchInfo(String shopNo){ //지점 정보
		return mapper.branchInfo(shopNo);
	}
	public int branchModify(Map<String, Object> map) { //지점 정보 수정
		System.out.println(map);
		int result = 0;
		result = mapper.branchModify(map);
		return result;
	}
	public int branchDelete(String shopNo) { //지점 삭제
		int result = 0;
		result = mapper.branchDelete(shopNo);
		System.out.println("123 :" + result);
		return result;
	}
}
