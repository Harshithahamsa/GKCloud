package com.gkt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Useranswer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int useranswerid;
	private String answer;
	
	public int getUseranswerid() {
		return useranswerid;
	}
	public void setUseranswerid(int useranswerid) {
		this.useranswerid = useranswerid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Useranswer(int useranswerid, String answer) {
		super();
		this.useranswerid = useranswerid;
		this.answer = answer;
	}
	public Useranswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
