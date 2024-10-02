package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); // if it is not getting fine name so need to mantioned manually
		SessionFactory factory = cfg.buildSessionFactory();
		
		
		//Student1
		Student std1 = new Student();
		std1.setId(14134);
		std1.setName("Naredra Modi");
		std1.setCity("Varanasi");
		
		//Certificate
		Certificate certi = new Certificate();
		
		certi.setCourse("Android");
		certi.setDuration("2 Months");
		std1.setCerti(certi);
		
		//Student2
		Student std2 = new Student();
		std2.setId(56734);
		std2.setName("Rajanikant");
		std2.setCity("South");
		
		//Certificate
		Certificate certi2 = new Certificate();
		
		certi2.setCourse("Acting");
		certi2.setDuration("3 Months");
		std2.setCerti(certi2);
		
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction(); //saving in db
		
		
		//save objects
		session.save(std1);
		session.save(std2);
		
		
		
		tx.commit();
		session.clear();
		factory.close();
	}
}
