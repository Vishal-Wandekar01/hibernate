package com.map.OneTM;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class QuestionOM {

	@Id
	@Column(name = "question_id")
	private int questionId;
	private String question;
	
	@OneToMany(mappedBy = "question")
	private List<AnswerOM> answer;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	

	public List<AnswerOM> getAnswer() {
		return answer;
	}

	public void setAnswer(List<AnswerOM> answer) {
		this.answer = answer;
	}
	
	

	public QuestionOM(int questionId, String question, List<AnswerOM> answer) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answer = answer;
	}

	public QuestionOM() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
