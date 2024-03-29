package com.etjava.comment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class EtjavaLogAspect {
	
	// 扫描所有controller包 给所有public修饰的请求方法添加统一的访问日志
	@Pointcut("execution(public * com.etjava.controller..*.*(..))")
	public void webLog() {
		
	}
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求内容
		log.info("REQUEST TIME : "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		log.info("REQUEST URL : " + request.getRequestURL().toString());
		log.info("REQUEST TYPE : " + request.getMethod());
		log.info("REQUEST IP : " + request.getRemoteAddr());
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			
			log.info("name:{},value:{}", name, request.getParameter(name));
		}
	}
	
	
	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		
		// 处理完请求，返回内容
		log.info("RESPONSE : " + ret);
	}
}
