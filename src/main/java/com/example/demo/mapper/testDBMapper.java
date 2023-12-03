package com.example.demo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface testDBMapper {
	public void insertDB(Map<String, Object> map);
}
