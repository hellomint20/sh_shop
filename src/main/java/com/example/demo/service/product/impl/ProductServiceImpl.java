package com.example.demo.service.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ShProductDTO;
import com.example.demo.common.GetMessage;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.product.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductMapper mapper;
	
	String msg = ""; // alert
	String url = ""; // url
	
	
	public String productRegister(ShProductDTO dto) {
		//String resultCd = "9997";
		//Map<String, Object> resultMap = mapper.productRegister(dto);
		
		//resultCd = resultMap.get("resultCd").toString();
		 int result = 0;
		if(result==1) { //재고 등록 성공
			msg = "재고 등록 성공";
			url = "/shop/productInfo";
		}else { //재고 등록 실패
			msg = "재고 등록 실패";
			url = "/shop/productInfo";
		}
		return GetMessage.getMessage(msg, url);
	}
}
