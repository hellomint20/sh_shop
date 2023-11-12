package com.example.demo.service.product;

import java.util.List;
import java.util.Map;

public interface ProductService {
	public List<Map<String, Object>> productAllList(); //전체 재고 목록
	public int productRegister(Map<String, Object> map); //재고 등록
	public Map<String, Object> productModifyPage(String itemNo); // 재고 하나의 정보
	public int productModify(Map<String, Object> map); //재고 수정
	public List<Map<String, Object>> stockList(String shopNo); //각 지점 재고 목록
	public List<Map<String, Object>> productGetList(String shopNo);
	public List<Map<String, Object>> itemCategory(); //상품 카테고리 가져오기
	public List<Map<String, Object>> itemState(); //상품 상태 가져오기
	public int stockCntModi(Map<String, Object> map); //상품 수량 수정(0이 아닐때)
	public int itemCntModiDo(Map<String, Object> map); //상품 수량 수정(0 일때)
}
