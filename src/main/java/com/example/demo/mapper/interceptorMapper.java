package com.example.demo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface interceptorMapper {
	public void insertInterId(Map<String, Object> map);
	public void insertInter(Map<String, Object> map);
}
