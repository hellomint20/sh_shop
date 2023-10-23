package com.example.demo.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BranchMapper {
	public List<Map<String, Object>> branchList();
	public int branchShopNo();
	public int branchRegister(Map<String, Object> map);
	public Map<String, Object> branchInfo(String shopNo);
	public int branchModify(Map<String, Object> map);
}
