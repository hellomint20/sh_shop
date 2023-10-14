package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.DTO.ShProductDTO;

@Mapper
public interface ProductMapper {
	public Map<String, Object> productAllList(); //전체 재고 목록
	public Map<String, Object> productList(String shopNo); //각 지점 재고 목록
	public Map<String, Object> productgetList(String itemNo); ///재고 하나의 정보
	public int productRegister(ShProductDTO dto);
}
