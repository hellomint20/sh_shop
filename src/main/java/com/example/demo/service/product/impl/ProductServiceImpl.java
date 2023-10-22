package com.example.demo.service.product.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	
	public List<Map<String, Object>> productAllList() { //전체 재고 목록
		List<Map<String, Object>> list = mapper.productAllList();
		return list;
	}
	
	public Map<String, Object> productList(String shopNo){ //각 지점 재고 목록
		Map<String, Object> stock = mapper.productList(shopNo);
		return stock;
		}
	
	public Map<String, Object> productgetList(String itemNo){ //재고 하나의 정보
		Map<String, Object> pro = mapper.productgetList(itemNo);
		return pro;
	}
	
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
