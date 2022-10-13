package com.etjava.comment;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {

	private Integer num = 1;
	
	@Scheduled(fixedRate = 5000)
	public void test() {
		System.out.println("====================["+num+++"]========================");
	}
}
