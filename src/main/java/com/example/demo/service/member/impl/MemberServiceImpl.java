package com.example.demo.service.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ShMemberDTO;
import com.example.demo.mapper.MemberMapper;
import com.example.demo.service.member.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper mapper;
	
	String msg = ""; // alert
	String url = ""; // url
	

	public ShMemberDTO memberInfo(String id) {
		ShMemberDTO dto = mapper.getInfo(id);
		return dto;
	}
}
