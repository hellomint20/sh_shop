package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.DTO.ShMemberDTO;

@Mapper
public interface MemberMapper {
	public ShMemberDTO getInfo(String id);
	public int register(ShMemberDTO dto);
}
