package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.DTO.ShProductDTO;

@Mapper
public interface ProductMapper {
	public int productRegister(ShProductDTO dto);
}
