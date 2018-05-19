package com.cfyj.weilan.config;

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
import org.springframework.core.annotation.Order;

/**
 * 暂时对响应头设置为可跨域
 * @author cfyj
 *2017年12月16日 下午6:30:17
 *
 */
@WebFilter(filterName="RespHeaderFilter",urlPatterns="/*")
@Order(10)
public class RespHeaderFilter implements Filter{
	
	private Logger log = LoggerFactory.getLogger(RespHeaderFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("init RespHeaderFilter");
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE"); 
		response.setHeader("Access-Control-Max-Age", "3600"); //设置过期时间 
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization"); 
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 支持HTTP 1.1. 
		response.setHeader("Pragma", "no-cache"); // 支持HTTP 1.0. response.setHeader("Expires", "0"); 
		log.info("RespHeaderFilter : 设置跨域的响应头");
		chain.doFilter(request, response);
		
		
		
		
		
		
	}

	@Override
	public void destroy() {
		log.info("destroy RespHeaderFilter");
		
	}

}
