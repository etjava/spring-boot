package com.etjava.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {

	// fixedRate 单位是毫秒
	@Scheduled(fixedRate = 2000)
	public void showTime() {
		System.out.println("CURRENT TIME IS : "+new SimpleDateFormat("YYYY-MM-DD HH:mm:ss:SSS").format(new Date()));
	}
}
