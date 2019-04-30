package com.challenge.utl;

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
			// grab credentials and URL from environment variables 
			
			System.out.println("hello1");
			
			c.setProperty("hibernate.connection.username", System.getenv("EMP2_DB_USERNAME"));
			c.setProperty("hibernate.connection.password", System.getenv("EMP2_DB_PASS"));
			c.setProperty("hibernate.connection.url", System.getenv("EMP2_DB_URL")); 
			c.configure(); 
			
			System.out.println("hello1");
			
			sessionFactory = c.buildSessionFactory(); 

		}
		
		return sessionFactory; 
		
	}
	
}
