package com.example.demo.service.branch;

import java.util.List;
import java.util.Map;

import com.example.demo.DTO.ShShopDTO;

public interface BranchService {
	public List<Map<String, Object>> branchList();
	public String branchRegister(Map<String, Object> map);
	public Map<String, Object> branchInfo(String shopNo);
	public String branchModify(Map<String, Object> map);
}
