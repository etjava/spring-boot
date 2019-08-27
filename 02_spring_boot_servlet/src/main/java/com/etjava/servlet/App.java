package com.etjava.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // 在springboot 启动时会扫码@WebServlet注解 并实例化
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
