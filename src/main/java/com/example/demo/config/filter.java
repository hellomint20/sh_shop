package com.example.demo.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.controller.ProductController;

@WebFilter(urlPatterns = { "/shop/productModiDo" })
public class filter implements Filter {

	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	private final Logger filterLog = LoggerFactory.getLogger("XSS_filter_log");
	private FilterConfig filterConfig;

	// 필터 인스턴스 초기화
	public void init(FilterConfig filterConfig) throws ServletException {
		LOGGER.info("[ ::: 필터 인스턴스 초기화 ::: ]");
		filterLog.info("[ ::: 필터 인스턴스 초기화 ::: ]");

		this.filterConfig = filterConfig;
	}

	@Override // 전/후 처리, Request, Response가 필터를 거칠 때 수행되는 메소드, chain.doFilter() 기점으로 request, response 나눠짐
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String requestURI = req.getRequestURI();
		LOGGER.info("[ ::: Request( "+requestURI+" ) 필터 ::: ]" );
		filterLog.info("[ ::: Request( "+requestURI+" ) 필터 ::: ]" );
		RequestWrapper requestWrapper = null;		
		try{	
			requestWrapper = new RequestWrapper(req);
		}catch(Exception e){	
			e.printStackTrace();
		}
		chain.doFilter(requestWrapper, response);

		LOGGER.info("[ ::: Response( "+requestURI+" ) 필터 ::: ]");
		filterLog.info("[ ::: Response( "+requestURI+" ) 필터 ::: ]");

	}

	// 필터 인스턴스 종료
	public void destory() {
		LOGGER.info("[ ::: 필터 인스턴스 종료 ::: ]");
		filterLog.info("[ ::: 필터 인스턴스 종료 ::: ]");
		this.filterConfig = null;
	}

}
