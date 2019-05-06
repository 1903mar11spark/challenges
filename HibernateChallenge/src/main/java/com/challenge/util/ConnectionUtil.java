package com.challenge.util;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class ConnectionUtil 
{
	private ConnectionUtil() 
	{
		super();
	}
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() 
	{
		if (sessionFactory == null) 
		{

			Configuration c = new Configuration();

			c.setProperty("hibernate.connection.employee", System.getenv("EMPLOYEE"));
			c.setProperty("hibernate.connection.requests", System.getenv("REQUESTS"));
		
			c.configure(); 
			
			sessionFactory = c.buildSessionFactory();
		
		}
		return sessionFactory;
	}
	
	
	
	
	
}