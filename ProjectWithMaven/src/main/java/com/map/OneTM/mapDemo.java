package com.map.OneTM;

import java.util.ArrayList;
import java.util.List;

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
		QuestionOM q1 = new QuestionOM();
		q1.setQuestionId(1212);
		q1.setQuestion("What is Java ?");
		
		//creating answer1
		AnswerOM answer = new AnswerOM();
		answer.setAnswerId(343);
		answer.setAnswer("Java is programming language");
		answer.setQuestion(q1);
		
		
		//creating answer2
		AnswerOM answer2 = new AnswerOM();
		answer2.setAnswerId(344);
		answer2.setAnswer("With the help of Java we can create Software");
		answer2.setQuestion(q1);
		
		//creating answer3
		AnswerOM answer3 = new AnswerOM();
		answer3.setAnswerId(345);
		answer3.setAnswer("Java has different types of freamework");
		answer3.setQuestion(q1);
				
		List<AnswerOM> list = new ArrayList<AnswerOM>();
		list.add(answer);
		list.add(answer2);
		list.add(answer3);
		
		q1.setAnswer(list);
		
		//session
		Session s = factory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		//save
		s.save(q1);
		s.save(answer);
		s.save(answer2);
		s.save(answer3);
		
		
		tx.commit();
		
		
		//fetching
				QuestionOM newQ = (QuestionOM)s.get(QuestionOM.class, 1212);
				System.out.println(newQ.getQuestion());
				
				for(AnswerOM a : newQ.getAnswer()) {
					System.out.println(a.getAnswer());
				}
				
				
		s.close();
		factory.close();

	}

	
}
