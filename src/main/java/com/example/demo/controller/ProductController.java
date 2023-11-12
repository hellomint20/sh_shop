package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.product.ProductService;

@Controller
@RequestMapping("shop")
public class ProductController {

	@Autowired
	ProductService ps;

	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@GetMapping("/productAllList") // 전체 재고 목록
	public String productAllList(Model model) {
		LOGGER.info("[ ::: shop/productAllList ::: ]");
		List<Map<String, Object>> list = ps.productAllList(); // 전체 품목 목록 가져오기
		model.addAttribute("list", list);
		return "shop/product/productAllList";
	}

	@GetMapping("/productRegister/page") // 재고 등록 페이지
	public String productRegisterPage(Model model) {
		model.addAttribute("itemCategory", ps.itemCategory()); // 상품 카테고리 가져오기
		model.addAttribute("itemState", ps.itemState());// 상품 상태 가져오기
		return "shop/product/productRegister";
	}

	@PostMapping("/productRegister/do") // 재고 DB 등록
	public ModelAndView productRegisterDo(@RequestBody Map<String, Object> map) {
		LOGGER.info("[ ::: shop/productRegister/do ::: ]");

		ModelAndView mav = new ModelAndView("jsonView");

		int result = 99;

		try {
			result = ps.productRegister(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("result", result);

		return mav;
	}

	@GetMapping("/productGetList") // 지점별 재고 목록
	public String productList(HttpSession session, Model model) {
		LOGGER.info("[ ::: shop/productGetList ::: ]");
		List<Map<String, Object>> stock = new ArrayList<>();
		List<Map<String, Object>> product = new ArrayList<>();
		try {
			stock = ps.stockList(session.getAttribute("shopNo").toString());
			product = ps.productGetList(session.getAttribute("shopNo").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("stock", stock);
		model.addAttribute("product", product);
		return "shop/product/productGetList";
	}

	@PostMapping("/productModi")
	public String modi(String itemNo, Model model) {
		LOGGER.info("[ ::: shop/productModi ::: ]");
		try {
			model.addAttribute("product", ps.productModifyPage(itemNo));
			model.addAttribute("itemCategory", ps.itemCategory()); // 상품 카테고리 가져오기
			model.addAttribute("itemState", ps.itemState());// 상품 상태 가져오기
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "shop/product/productModi";
	}

	@PostMapping("/productModiDo") // 재고 수정 DB 등록
	public ModelAndView modiDo(@RequestBody Map<String, Object> map) {
		LOGGER.info("[ ::: shop/modiDo ::: ]");
		ModelAndView mav = new ModelAndView("jsonView");

		int result = 99;

		try {
			result = ps.productModify(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("result", result);
		return mav;
	}

	@PostMapping("/stockCntModiDo")
	public ModelAndView stockCntModiDo(@RequestBody Map<String, Object> map) {
		LOGGER.info("[ ::: shop/stockCntModiDo ::: ]");
		ModelAndView mav = new ModelAndView("jsonView");

		int result = 99;

		try {
			result = ps.stockCntModi(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("result", result);
		return mav;
	}

	@PostMapping("/itemCntModiDo")
	public ModelAndView itemCntModiDo(@RequestBody Map<String, Object> map) {
		LOGGER.info("[ ::: shop/itemCntModiDo ::: ]");
		ModelAndView mav = new ModelAndView("jsonView");

		int result = 99;

		try {
			result = ps.itemCntModiDo(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("result", result);
		return mav;
	}
}
