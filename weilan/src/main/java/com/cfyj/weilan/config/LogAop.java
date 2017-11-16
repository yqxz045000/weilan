package com.cfyj.weilan.config;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.cfyj.weilan.service.impl.LogServiceImpl;

/**
 * 
 * @author cfyj 2017年11月13日 下午9:28:45
 *
 *
 */
@Aspect
@Order(1)
@Component
public class LogAop extends LogServiceImpl {

	@Pointcut("execution(* com..controller.*.*(..))")
	public void controllerAop() {

	}

	@Before(value = "controllerAop()")
	public void beforeRun(ProceedingJoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		List<Object> list = new ArrayList();
		for (Object param : args) {
			list.add(param);
		}
		log.info("方法:{},参数:{}", joinPoint.getSignature(), JSON.toJSONString(list));
	}

	@AfterReturning(value = "init()",returning="returnValue",pointcut="controllerAop()")
	public void afterRun(Object returnValue) {
		log.info(JSON.toJSONString(returnValue));
		
	}

}