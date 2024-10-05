package com.map.OneTM;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class AnswerOM {

	@Id
	@Column(name= "answer_id" )
	private int answerId;
	private String answer;
	
	@ManyToOne
	private QuestionOM question;
	
	
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public QuestionOM getQuestion() {
		return question;
	}
	public void setQuestion(QuestionOM question) {
		this.question = question;
	}
	public AnswerOM(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
	}
	
	public AnswerOM() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
