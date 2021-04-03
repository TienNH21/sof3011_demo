package com.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.my_demo.entity.User;

public class HibernateUtil {
	private static SessionFactory factory;
	private static Session session;
	public static SessionFactory getSessionFactory()
	{
		if (factory == null || !factory.isOpen()) {
			try {
				Configuration config = new Configuration();
				
				config.configure("hibernate.cfg.xml");
				
				factory = config.buildSessionFactory();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return factory;
	}
	
	public static Session getSession()
	{
		if (session == null || !session.isOpen()) {
			session = getSessionFactory().openSession();
		}
		
		session.clear();
		
		return session;
	}
}
