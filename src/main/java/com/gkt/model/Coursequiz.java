package com.gkt.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Coursequiz {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quizid")
    private Long quizid;
    private String questionno;
    private String questiontype;
    private String imgurl;
    private String question;
    private String answertype;
    private int minselect;
    private int points;
	private String correctAnswer;
	private int sectionid;
	private String section_desc;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "quizid")
    private List<Useranswer> useranswer;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "quizid")
    private List<Options> options;

	public Long getQuizid() {
		return quizid;
	}

	public void setQuizid(Long quizid) {
		this.quizid = quizid;
	}

	public String getQuestionno() {
		return questionno;
	}

	public void setQuestionno(String questionno) {
		this.questionno = questionno;
	}

	public String getQuestiontype() {
		return questiontype;
	}

	public void setQuestiontype(String questiontype) {
		this.questiontype = questiontype;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswertype() {
		return answertype;
	}

	public void setAnswertype(String answertype) {
		this.answertype = answertype;
	}

	public int getMinselect() {
		return minselect;
	}

	public void setMinselect(int minselect) {
		this.minselect = minselect;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}



	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public int getSectionid() {
		return sectionid;
	}

	public void setSectionid(int sectionid) {
		this.sectionid = sectionid;
	}

	public String getSection_desc() {
		return section_desc;
	}

	public void setSection_desc(String section_desc) {
		this.section_desc = section_desc;
	}

	public List<Options> getOptions() {
		return options;
	}

	public void setOptions(List<Options> options) {
		this.options = options;
	}

	
	

	public List<Useranswer> getUseranswer() {
		return useranswer;
	}

	public void setUseranswer(List<Useranswer> useranswer) {
		this.useranswer = useranswer;
	}

	public Coursequiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coursequiz(Long quizid, String questionno, String questiontype, String imgurl, String question,
			String answertype, int minselect, int points, String correctAnswer, int sectionid, String section_desc,
			List<Useranswer> useranswer, List<Options> options) {
		super();
		this.quizid = quizid;
		this.questionno = questionno;
		this.questiontype = questiontype;
		this.imgurl = imgurl;
		this.question = question;
		this.answertype = answertype;
		this.minselect = minselect;
		this.points = points;
		this.correctAnswer = correctAnswer;
		this.sectionid = sectionid;
		this.section_desc = section_desc;
		this.useranswer = useranswer;
		this.options = options;
	}

	@Override
	public String toString() {
		return "Coursequiz [quizid=" + quizid + ", questionno=" + questionno + ", questiontype=" + questiontype
				+ ", imgurl=" + imgurl + ", question=" + question + ", answertype=" + answertype + ", minselect="
				+ minselect + ", points=" + points + ", correctAnswer=" + correctAnswer + ", sectionid=" + sectionid
				+ ", section_desc=" + section_desc + ", useranswer=" + useranswer + ", options=" + options + "]";
	}

	
	 

	
    
	
    

	
   

}
