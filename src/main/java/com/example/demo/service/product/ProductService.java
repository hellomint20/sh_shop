package com.example.demo.service.product;

import java.util.ArrayList;
import java.util.Map;

import com.example.demo.DTO.ShProductDTO;

public interface ProductService {
	public Map<String, Object> productAllList(); //전체 재고 목록
	public Map<String, Object> productList(String shopNo); //각 지점 재고 목록
	public Map<String, Object> productgetList(String itemNo); //재고 하나의 정보
	public String productRegister(ShProductDTO dto);
}
