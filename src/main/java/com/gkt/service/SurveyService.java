package com.gkt.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gkt.dto.SurveyDTO;
import com.gkt.repository.CourseQuizRepository;
import com.gkt.repository.SurveyRepository;

@Service
public class SurveyService {
	@Autowired
	private SurveyRepository surveyrepo;
	@Autowired
	private CourseQuizRepository coursequizrepo;
	@Autowired
	ObjectMapper objectMapper;

	public JSONObject getsurveydata() throws JsonMappingException, JsonProcessingException {
//	    List<SurveyDTO> surveys = surveyrepo.getsurveydata();
//	    JSONObject surveyObj = new JSONObject();
//	    JSONArray section = new JSONArray();
//	    for(SurveyDTO survey : surveys) {
//	    	JSONObject obj = new JSONObject();
//	    	obj.put("sectionid", survey.getsectionid());
//	    	obj.put("tabOrder", survey.gettab_order());
//	    	obj.put("sectionDesc", survey.getsection_desc());
//	    	obj.put("numberOfQuestions", survey.getnumber_of_questions());
//	    	obj.put("bgColor", survey.getbg_color());
//	    	obj.put("color", survey.getcolor());
//	    	obj.put("questions", survey.getquestions());
//	    	section.add(obj);
//	    	
//	    }
//	 
//	    surveyObj.put("id", surveys.get(0).getid());
//	    surveyObj.put("surveyType", surveys.get(0).getsurvey_type());
//	    surveyObj.put("timeBased", surveys.get(0).gettime_based());
//	    surveyObj.put("timeToComplete", surveys.get(0).gettime_to_complete());
//	    surveyObj.put("section", section);
//	    
//	    return surveyObj;
		
		
		
		List<SurveyDTO> surveys = surveyrepo.getsurveydata();
		JSONArray section = new JSONArray();

		for (int i = 0; i < surveys.size(); i++) {
		    SurveyDTO survey = surveys.get(i);
		    JSONObject obj = new JSONObject();
		    obj.put("sectionid", survey.getsectionid());
		    obj.put("tabOrder", survey.gettab_order());
		    obj.put("sectionDesc", survey.getsection_desc());
		    obj.put("numberOfQuestions", survey.getnumber_of_questions());
		    obj.put("color", survey.getcolor());
		    obj.put("questions", survey.getquestions());
		    if (i == 0) {
		        obj.put("bgColor", "#114180");
		    } else {
		        obj.put("bgColor", survey.getbg_color());
		    }

		    section.add(obj);
		}

		JSONObject surveyObj = new JSONObject();
		surveyObj.put("id", surveys.get(0).getid());
	    surveyObj.put("surveyType", surveys.get(0).getsurvey_type());
	    surveyObj.put("timeBased", surveys.get(0).gettime_based());
//	    surveyObj.put("timeToComplete", surveys.get(0).gettime_to_complete());
	    if (surveys.get(0).gettime_based()) {
	        surveyObj.put("timeToComplete", surveys.get(0).gettime_to_complete());
	    } else {
	        surveyObj.put("timeToComplete", 0);
	    }
		surveyObj.put("sections", section);
		return surveyObj;

	}

}
