package com.challenge.util;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class ConnectionUtil {

	
	
	private ConnectionUtil() {
		super();
	}
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {

			Configuration c = new Configuration();

			c.setProperty("hibernate.connection.username", System.getenv("BAT_DB_USER"));
			c.setProperty("hibernate.connection.password", System.getenv("BAT_DB_PASS"));
			c.setProperty("hibernate.connection.url", System.getenv("BAT_DB_URL"));
			c.configure(); // by default, looking hibernate.cfg.xml in src/main/resources
			sessionFactory = c.buildSessionFactory();
		}
		return sessionFactory;
	}
	
	
	
	
	
}
