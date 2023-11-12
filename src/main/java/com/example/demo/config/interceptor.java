package com.example.demo.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class interceptor implements HandlerInterceptor{
	private final Logger LOGGER = LoggerFactory.getLogger(interceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		LOGGER.info("[ ::: Interceptor preHandle ::: ]");
		System.out.println(request.getRequestURI()); //uri
		System.out.println(request.getServerPort()); //PORT
		System.out.println(request.getHeader("X-Forwarded-For"));
		System.out.println(request.getRemoteAddr());
		
		
		HttpSession session = request.getSession();
        
		// 요청 URL 
		String url = request.getRequestURI();
		
		// 아래 URL이 아니라면 로그인 체크
		if((url.equals("/shop/productAllList"))){
			System.out.println("inte: "+session.getAttribute("memberId"));
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		LOGGER.info("[ ::: Interceptor postHandle ::: ]");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
}
