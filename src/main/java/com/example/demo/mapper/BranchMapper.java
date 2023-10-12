package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.DTO.ShShopDTO;

@Mapper
public interface BranchMapper {
	public int branchRegister(ShShopDTO dto);
}
