package com.example.demo.service.branch;

import java.util.List;
import java.util.Map;

public interface BranchService {
	public List<Map<String, Object>> branchList(); //지점 목록 조회
	public int branchRegister(Map<String, Object> map); //지점 등록
	public Map<String, Object> branchInfo(String shopNo); //지점 정보
	public int branchModiDo(Map<String, Object> map); //지점 정보 수정
	public int branchDelete(String shopNo); //지점 삭제
}
