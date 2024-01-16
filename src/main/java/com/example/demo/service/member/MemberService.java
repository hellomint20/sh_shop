package com.example.demo.service.member;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

public interface MemberService {
	public int register(Map<String, Object> map);
	public Map<String, Object> memberInfo(String id);
	public int memberModify(Map<String, Object> map);
	public int memberDelete(String id);
	public List<Map<String, Object>> branchList(); //지점 목록 가져오기
	public List<Map<String, Object>> authTypeList(); //관리자 등급 가져오기
	public List<Map<String, Object>> memberList(); //직원 리스트
}
