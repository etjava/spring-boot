package com.etjava.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * spring boot 整合Listener 方式1
 * @author ETJAVA
 *
 */
@WebListener
public class FirstListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("First Listener Destroyed...");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("First Listener Init...");
	}

}
