package com.example.demo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.DTO.ShMemberDTO;

@Mapper
public interface MemberMapper {
	public Map<String, Object> getInfo(String id); //id로 개인정보 가져오기
	public int register(ShMemberDTO dto); //회원가입
	public int register2(Map<String, Object> map); //회원가입
	public Map<String, Object> getShopNo(String shopName); //이름으로 번호 가져오기
	public Map<String, Object> getShopName(String shopNo); //번호로 이름 가져오기
	public int memberModify(ShMemberDTO dto); //개인정보 수정
	public int memberDelete(String id); //회원 탈퇴
}
