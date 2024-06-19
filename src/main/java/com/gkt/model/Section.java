package com.gkt.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "section")
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sectionid")
	private Long sectionid;

	@Column(name = "tab_order")
	private int tabOrder;

	@Column(name = "section_desc")
	private String sectionDesc;

	@Column(name = "number_of_questions")
	private int numberOfQuestions;

	@Column(name = "bg_color")
	private String bgColor;

	@Column(name = "color")
	private String color;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(referencedColumnName = "id")
	private Survey survey;

	@Transient
	private int questions;

	public int getquestions() {
		return questions;
	}

	public void setquestions(int questions) {
		this.questions = questions;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public Long getSectionid() {
		return sectionid;
	}

	public void setSectionid(Long sectionid) {
		this.sectionid = sectionid;
	}

	public int getTabOrder() {
		return tabOrder;
	}

	public void setTabOrder(int tabOrder) {
		this.tabOrder = tabOrder;
	}

	public String getSectionDesc() {
		return sectionDesc;
	}

	public void setSectionDesc(String sectionDesc) {
		this.sectionDesc = sectionDesc;
	}

	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Section() {
	}

	public Section(Long sectionid, int tabOrder, String sectionDesc, int numberOfQuestions, String bgColor,
			String color, Survey survey, int questions) {
		super();
		this.sectionid = sectionid;
		this.tabOrder = tabOrder;
		this.sectionDesc = sectionDesc;
		this.numberOfQuestions = numberOfQuestions;
		this.bgColor = bgColor;
		this.color = color;
		this.survey = survey;
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Section [sectionid=" + sectionid + ", tabOrder=" + tabOrder + ", sectionDesc=" + sectionDesc
				+ ", numberOfQuestions=" + numberOfQuestions + ", bgColor=" + bgColor + ", color=" + color + ", survey="
				+ survey + ", questions=" + questions + "]";
	}

}
