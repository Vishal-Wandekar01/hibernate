package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		
		//creating student
		Student std = new Student();
		std.setId(102);
		std.setName("Jhon");
		std.setCity("UK");
		System.out.println(std);
		
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(std);
		
		tx.commit();
		
		session.close();
		
	}
}
