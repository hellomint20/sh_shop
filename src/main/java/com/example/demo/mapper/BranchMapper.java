package com.example.demo.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BranchMapper {
	public List<Map<String, Object>> branchList(); //지점 목록 조회
	public int branchShopNo();	//지점 번호 가져오기
	public int branchRegister(Map<String, Object> map); //지점 등록
	public Map<String, Object> branchInfo(String shopNo); //지점 정보
	public int branchModiDo(Map<String, Object> map); //지점 정보 수정
	public int branchDelete(String shopNo); //지점 삭제
}
