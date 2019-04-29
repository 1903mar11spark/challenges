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
			
			c.setProperty("hibernate.connection.username", System.getenv("DB_USERNAME"));
			c.setProperty("hibernate.connection.password", System.getenv("DB_PASS"));
			c.setProperty("hibernate.connection.url", System.getenv("DB_HOSTNAME"));
			c.configure(); 
			sessionFactory = c.buildSessionFactory();
		}
		return sessionFactory;
	}

}
