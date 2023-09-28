package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.DTO.ShMemberDTO;

@Mapper
public interface ShopMapper {
	public ShMemberDTO loginChk(String id);
}
