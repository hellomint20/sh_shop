package com.example.demo.service.branch.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	
	public String branchRegister(ShShopDTO dto) {
		// 현재 날짜 구하기
        LocalDate now = LocalDate.now();
        // 포맷 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        // 포맷 적용
        String formatedNow = now.format(formatter);
        // 결과 출력
        System.out.println(formatedNow); //202310
        
        //☆지점번호 가져오기
        
		//지점 번호 넣어주고 지점 번호까지 dto로 넘겨준다 ex) 2023120002
		//dto.setShopNo() 
        
        
		int result = 0;
		//result = mapper.branchRegister(dto);
		
		if(result == 1) { //지점 등록 성공
			msg = "지점 등록 성공";
			url = "/shop/branchInfo";
		}else { //지점 등록 실패
			msg = "지점 등록 실패";
			url = "/shop/branchInfo"; ///??? 쓰던 내용으로 돌려야 하나?
		}
		return GetMessage.getMessage(msg, url);
	}
}
