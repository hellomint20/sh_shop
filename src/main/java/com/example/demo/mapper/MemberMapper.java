package com.example.demo.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	public Map<String, Object> getInfo(String id); //id로 개인정보 가져오기
	public List<Map<String, Object>> branchList(); //지점 목록 가져오기
	public List<Map<String, Object>> authTypeList(); //관리자 등급 가져오기
	public int register(Map<String, Object> map); //회원가입
	public Map<String, Object> getShopNo(String shopName); //이름으로 번호 가져오기
	public Map<String, Object> getShopName(String shopNo); //번호로 이름 가져오기
	public int memberModify(Map<String, Object> map); //개인정보 수정
	public int memberDelete(String memberId); //회원 삭제
	public List<Map<String, Object>> memberList(); //직원 리스트
}
