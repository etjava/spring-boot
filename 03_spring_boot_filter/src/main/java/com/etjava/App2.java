package com.etjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.etjava.filter1.SecondFilter;
import com.etjava.servlet.SecondServlet;

@SpringBootApplication
public class App2 {

	public static void main(String[] args) {
		SpringApplication.run(App2.class, args);
	}
	
	
	/**
	 * 	注册Servlet
	 * @return
	 */
	@Bean
	public ServletRegistrationBean getServletRegistrationBean() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
		bean.addUrlMappings("/second");
		return bean;
	}
	
	
	/**
	 * 	注册Filter
	 * @return
	 */
	@Bean
	public FilterRegistrationBean getFilterRegistration() {
		FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
		bean.addUrlPatterns(new String[] {"/second","*.adtion"});
		return bean;
	}
}
