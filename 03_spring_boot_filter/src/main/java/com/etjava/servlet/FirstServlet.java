package com.etjava.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	测试Filter拦截Servlet
 * @author 刘伟
 *
 */

/*
 * <servlet>
 * 	<servlet-name>FirstServlet</servlet-name>
 * 	<servlet-class>com.etjava.servlet.FirstServlet</servlet-class>
 * </servlet>
 * <servlet-mapping>
 * 	<servlet-name>FirstServlet</servlet-name>
 *  <url-pattern>/first</url-pattern>
 * </servlet-mapping>
 */

@WebServlet(name="FirstServlet",urlPatterns = "/first")
public class FirstServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("进入Servlet...");
		System.out.println("First Servlet.");
	}
}
