package com.example.demo.service.product.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.product.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper mapper;

	int result = 99;

	public List<Map<String, Object>> productAllList() { // 전체 재고 목록
		List<Map<String, Object>> list = new ArrayList<>();

		try {
			//throw new IOException();
			list = mapper.productAllList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int productRegister(Map<String, Object> map) { // 재고 등록

		try {
			result = mapper.productRegister(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Map<String, Object> productModifyPage(String itemNo) { // 재고 하나의 정보
		Map<String, Object> list = new HashMap<>();

		try {
			list = mapper.productModifyPage(itemNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int productModify(Map<String, Object> map) { // 재고 수정
		int result = 99;

		try {
			result = mapper.productModify(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Map<String, Object>> stockList(String shopNo) { // 각 지점 재고 목록
		List<Map<String, Object>> stock = new ArrayList<>();

		try {
			stock = mapper.stockList(shopNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stock;
	}

	public List<Map<String, Object>> productGetList(String shopNo) {
		List<Map<String, Object>> product = new ArrayList<>();

		try {
			product = mapper.productGetList(shopNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	public List<Map<String, Object>> itemCategory() { // 상품 카테고리 가져오기
		List<Map<String, Object>> itemCategoryList = new ArrayList<Map<String, Object>>();

		try {
			itemCategoryList = mapper.itemCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemCategoryList;
	}

	public List<Map<String, Object>> itemState() { // 상품 상태 가져오기
		List<Map<String, Object>> itemStateList = new ArrayList<Map<String, Object>>();

		try {
			itemStateList = mapper.itemState();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemStateList;
	}

	public int stockCntModi(Map<String, Object> map) { //상품 수량 수정(0이 아닐때)

		try {
			result = mapper.stockCntModi(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int itemCntModiDo(Map<String, Object> map) { //상품 수량 수정(0 일때)

		try {
			result = mapper.itemCntModiDo(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
