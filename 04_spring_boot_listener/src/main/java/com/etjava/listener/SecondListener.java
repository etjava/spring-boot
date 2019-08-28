package com.etjava.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * spring boot 整合Listener 方式2
 * @author ETJAVA
 *
 */
public class SecondListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Second Listener Destroyed...");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Second Listener Init...");
	}

}
