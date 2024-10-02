package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
public static void main(String[] args) {
	//get, load
	
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml"); // if it is not getting fine name so need to mantioned manually
	SessionFactory factory = cfg.buildSessionFactory();
	
	Session session = factory.openSession();
	
	//Student
	//get-student:102
	Student student = (Student) session.get(Student.class, 105);// null
	System.out.println(student);
	
	//load-student:111
	Student student2 = (Student) session.load(Student.class, 111);
	System.out.println(student2);
	
	//Address
	//get-address:2
	Address add = (Address) session.get(Address.class, 2);
	System.out.println(add);
	System.out.println(add.getStreet()+" : "+ add.getCity());
	
	//load-address:1
	Address add2 = (Address) session.load(Address.class, 3); //throw ObjectNotFoundException
	System.out.println(add2);
	
	session.close();
	factory.close();
}
}
