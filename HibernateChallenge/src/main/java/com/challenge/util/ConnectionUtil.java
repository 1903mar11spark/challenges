package com.challenge.util;

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
			c.setProperty("hibernate.connection.username", System.getenv("HIB_DB_USERNAME"));
			c.setProperty("hibernate.connection.password", System.getenv("HIB_DB_PASSWORD"));
			c.setProperty("hibernate.connection.url", System.getenv("HIB_DB_URL"));
			c.configure(); 
			sessionFactory = c.buildSessionFactory();
		}
		return sessionFactory;
	}
	
}