package com.gkt.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "survey")
public class Survey {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "survey_type")
	private String surveyType;

	@Column(name = "time_based")
	private boolean timeBased;

	@Column(name = "time_to_complete")
	private int timeToComplete;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "survey")
	private List<Section> section;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSurveyType() {
		return surveyType;
	}

	public void setSurveyType(String surveyType) {
		this.surveyType = surveyType;
	}

	public boolean isTimeBased() {
		return timeBased;
	}

	public void setTimeBased(boolean timeBased) {
		this.timeBased = timeBased;
	}

	public int getTimeToComplete() {
		return timeToComplete;
	}

	public void setTimeToComplete(int timeToComplete) {
		this.timeToComplete = timeToComplete;
	}

	public List<Section> getSection() {
		return section;
	}

	public void setSection(List<Section> section) {
		this.section = section;
	}

	public Survey() {
	}

	public Survey(Long id, String surveyType, boolean timeBased, int timeToComplete, List<Section> section) {
		super();
		this.id = id;
		this.surveyType = surveyType;
		this.timeBased = timeBased;
		this.timeToComplete = timeToComplete;
		this.section = section;
	}

}
