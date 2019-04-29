package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil {

	private ConnectionUtil() {
		super();
	}
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration c = new Configuration();
			c.setProperty("hibernate.connection.username", System.getenv("connUser"));
			c.setProperty("hibernate.connection.password", System.getenv("connPassword"));
			c.setProperty("hibernate.connection.url", System.getenv("connUrl"));
			c.configure(); 
			sessionFactory = c.buildSessionFactory();
		}
		return sessionFactory;
	}
}
