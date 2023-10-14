package com.example.demo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.DTO.ShShopDTO;

@Mapper
public interface BranchMapper {
	public Map<String, Object> branchGetInfo(String shopName);
	public int branchRegister(ShShopDTO dto);
}
