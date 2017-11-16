package com.cfyj.weilan.config;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cfyj.weilan.domain.CodeDict;
import com.cfyj.weilan.domain.Response;

/**
 * 拦截全局异常
 * @author cfyj
 * 2017年11月13日 下午9:28:49
 *
 *
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
	
	private Logger log = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Response catchException(HttpServletRequest request, Exception ex) {
		log.error("访问资源："+request.getRequestURI()+",异常",ex);
		return new Response(CodeDict.EXEC);
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Response catchException(HttpServletRequest request, RuntimeException ex) {
		log.error("访问资源："+request.getRequestURI()+",异常",ex);
		return new Response(CodeDict.EXEC);
	}

}
