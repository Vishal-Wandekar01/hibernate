package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
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
		
		
		//creating Address
		Address ad = new Address();
		ad.setStreet("Street1 ");
		ad.setCity("DELHI");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(1234.123);
		
		//read image
		FileInputStream fis = new FileInputStream("src/main/java/Chiku.jpg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction(); // for saving data we use transaction
		
		session.save(std);
		session.save(ad);//will save in database
		
		tx.commit();
		
		session.close();
		
	
		System.out.println("Done.. ");
		
	}
}
