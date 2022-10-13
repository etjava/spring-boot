package com.etjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etjava.component.MyAsync;

@RestController
public class TestController {

	@Autowired
	private MyAsync myAsync;
	
	@Value("name") // 属性name要与application配置文件中的属性一致
	private String name;
	
	@RequestMapping("/login")
	public String hello(String username,String password) {
		
		StringBuffer buf = new StringBuffer();
		for(int i = 0; i< 10;i ++) {
			buf.append(i+" ,");
		}
		
		//@SuppressWarnings("unused")
		//int i = 1/0 ;
		return buf.substring(0, buf.length()-2).toString();
	}
	
	
	@RequestMapping("/async")
	public String async() {
		myAsync.async();
		
		System.out.println("主线程ID ："+Thread.currentThread().getId());
		System.out.println("name is :"+name);
		return "success : "+name;
		
	}
}
