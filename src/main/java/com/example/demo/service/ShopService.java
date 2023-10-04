package com.example.demo.service;

import com.example.demo.DTO.ShMemberDTO;
import com.example.demo.DTO.ShShopDTO;

public interface ShopService {
	public String loginChk(String id, String pw);
	public String register(ShMemberDTO dto);
	public String logout();
	public String branchRegister(ShShopDTO dto);
}
