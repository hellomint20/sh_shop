package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.DTO.ShMemberDTO;
import com.example.demo.DTO.ShShopDTO;

@Mapper
public interface ShopMapper {
	public ShMemberDTO getInfo(String id);
	public int register(ShMemberDTO dto);
	public int branchRegister(ShShopDTO dto);
}
