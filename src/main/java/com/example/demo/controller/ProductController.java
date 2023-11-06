package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/productList") // 지점별 재고 목록
	public String productList(HttpSession session, Model model, HttpServletResponse res) throws Exception {
		Map<String, Object> stock = ps.productList(session.getAttribute("shopNo").toString());
		// Map<String, Object> pro = ps.productgetList(stock.get("item_no").toString());
		model.addAttribute("stock", stock);
		// model.addAttribute("pro", pro);
		return "shop/product/productList";
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
			// result = ps.productModify(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("result", result);
		return mav;
	}

	@GetMapping("/productInfo") // 재고 상세정보
	public String productInfo() {
		return "shop/product/productInfo";
	}

	@GetMapping("/sellRefund") // 재고 판매/환불
	public String sell() {
		return "shop/product/sellRefund";
	}

}
