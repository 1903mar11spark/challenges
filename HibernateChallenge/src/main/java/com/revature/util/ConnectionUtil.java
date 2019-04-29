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
			// if no SessionFactory has been created, create one
			Configuration c = new Configuration();
			// grab credentials and url from environment variables
			c.getProperty("hibernate.connection.username");
			c.getProperty("hibernate.connection.password");
			c.getProperty("hibernate.connection.url");
			c.configure(); // by default, looking hibernate.cfg.xml in src/main/resources
			sessionFactory = c.buildSessionFactory();
		}
		return sessionFactory;
}
}
