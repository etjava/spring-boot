package com.etjava.exception;

import java.io.IOException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试全局捕获异常
 * 该类相当于动态代理或AOP配置全局捕获异常 只是这里使用注解形式 更为方便
 * 
 * 这里的@ControllerAdvice可以理解为定义该类为AOP切面 
 * 
 * Advice 是spring的AOP 
 * ControllerAdvice 是负责Controller中的AOP
 * @author etjava
 *
 */

@ControllerAdvice
public class GloableException {

	/**
	 * 当有controller发生异常时 这里可以进行捕获处理 例如栈溢出或内存不足等异常
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler({RuntimeException.class,IOException.class})
	public String runtimeException(RuntimeException e) {
		return "捕获全局的异常"+e.getMessage();
	}
}
