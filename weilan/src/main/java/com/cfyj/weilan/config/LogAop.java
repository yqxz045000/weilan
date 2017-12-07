package com.cfyj.weilan.config;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.cfyj.weilan.utils.BaseLogUtil;

/**
 * 
 * @author cfyj 2017年11月13日 下午9:28:45
 *
 *
 */
@Aspect
@Order(5)
@Component
public class LogAop extends BaseLogUtil {

	@Pointcut("execution(* com..controller.*.*(..))")
	public void controllerAop() {

	}

	@Before(value = "controllerAop()")
	public void beforeRun(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		List<Object> list = new ArrayList<Object>();
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
