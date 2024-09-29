package com.tut;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello Hibernate!.... This is Techmonk");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); // if it is not getting fine name so need to mantioned manually
		SessionFactory factory = cfg.buildSessionFactory();

		// SessionFactory factory = new
		// Configuration().configure().buildSessionFactory();

		System.out.println(factory);
//         factory.getCurrentSession();
		
		System.out.println(factory.isClosed());
	}
}
