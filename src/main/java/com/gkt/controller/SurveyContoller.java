package com.gkt.controller;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gkt.dto.SurveyDTO;
import com.gkt.model.Survey;
import com.gkt.repository.SurveyRepository;
import com.gkt.service.SurveyService;

@RestController
@CrossOrigin(origins = "*")
public class SurveyContoller {

	@Autowired
	private SurveyRepository surveyrepo;

	@Autowired
	private SurveyService surveyservice;

	@GetMapping("/getsurveytype")
	public JSONObject getsurvey() throws JsonMappingException, JsonProcessingException {
		return surveyservice.getsurveydata();
	}

}
