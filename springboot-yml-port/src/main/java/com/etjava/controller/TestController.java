package com.etjava.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Value("${name}")
	private String name;
	
	@RequestMapping("/login")
	public Object login(String userName,String password) {
		
		System.out.println("name is "+name);
		
		return name;
	}
}
