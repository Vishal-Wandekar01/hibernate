package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class mapDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); // if it is not getting fine name so need to mantioned manually
		SessionFactory factory = cfg.buildSessionFactory();
		
		//creating Question1
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is Java ?");
		
		//creating answer1
		Answer answer = new Answer();
		answer.setAnswerId(343);
		answer.setAnswer("Java is programming language");
		answer.setQuestion(q1);;
		q1.setAnswer(answer);
		
		

		//creating Question2
		Question q2 = new Question();
		q2.setQuestionId(242);
		q2.setQuestion("What is Collection Framework ?");
		
		//creating answer2
		Answer answer2 = new Answer();
		answer2.setAnswerId(344);
		answer2.setAnswer("API to work with objects with java");
		answer2.setQuestion(q2);
		q2.setAnswer(answer2);
		
		
		//session
		Session s = factory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		//save
		
		s.save(q1);
		s.save(q2);
		s.save(answer);
		s.save(answer2);
		
		
		tx.commit();
		
		
		//fetching
				Question newQ = (Question)s.get(Question.class, 242);
				System.out.println(newQ.getQuestion());
				System.out.println(newQ.getAnswer().getAnswer());
				
				
		s.close();
		factory.close();

	}

	
}
