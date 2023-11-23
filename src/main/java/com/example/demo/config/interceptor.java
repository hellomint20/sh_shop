package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.interceptor.interceptorService;

public class interceptor implements HandlerInterceptor{
	
	@Autowired
	interceptorService is;
	
	private final Logger LOGGER = LoggerFactory.getLogger(interceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		LOGGER.info("[ ::: Interceptor preHandle ::: ]");
		HttpSession session = request.getSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("url", request.getRequestURI().toString());
		map.put("port",Integer.toString(request.getServerPort()));
		map.put("ip",request.getRemoteAddr().toString());
		
		if(session.getAttribute("memberId") == null) {
			is.insertInter(map);
		}else {
			map.put("userId", session.getAttribute("memberId").toString());
			is.insertInterId(map);
		}

		// 요청 URL 
		String url = request.getRequestURI();
		
		// 아래 URL이 아니라면 로그인 체크
		if((url.equals("/shop/productAllList"))){
			if(session.getAttribute("memberId") == null) {
				response.sendRedirect("/");
				return false;
			}
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		LOGGER.info("[ ::: Interceptor postHandle ::: ]");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
}
