package com.etjava.component;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 	测试异步方法
 * @author etjav
 *
 */
@Component // 注入到spring中
public class MyAsync {

	@Async // 该注解表示此方法为异步调用
	public void async() {
		System.out.println("当前线程的ID是 :  "+Thread.currentThread().getId());
	}
	
}
