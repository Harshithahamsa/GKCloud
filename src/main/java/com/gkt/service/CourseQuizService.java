package com.gkt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gkt.model.Coursequiz;
import com.gkt.model.Options;
import com.gkt.model.Useranswer;
import com.gkt.repository.CourseQuizRepository;

@Service
public class CourseQuizService {
	
	@Autowired
	private CourseQuizRepository coursequizrepo;

	
	public JSONArray getquizQuestions() {
	    try {
	        List<Coursequiz> quizQuestions = coursequizrepo.getsurveydata();
	        
	        if (quizQuestions.isEmpty()) {
	            return new JSONArray();
	        }

	        Map<String, JSONArray> sections = new HashMap<>();

	        for (Coursequiz question : quizQuestions) {
	            String sectionDesc = question.getSection_desc();
	            if (!sections.containsKey(sectionDesc)) {
	                sections.put(sectionDesc, new JSONArray());
	            }

	            JSONObject questionJson = new JSONObject();
	            questionJson.put("quizid", question.getQuizid());
	            questionJson.put("questionno", question.getQuestionno());
	            questionJson.put("questiontype", question.getQuestiontype());
	            questionJson.put("imgurl", question.getImgurl());
	            questionJson.put("question", question.getQuestion());
	            questionJson.put("answertype", question.getAnswertype());
	            questionJson.put("minselect", question.getMinselect());
	            questionJson.put("points", question.getPoints());
	         
	            // User Answers
	            JSONArray userAnswerArray = new JSONArray();
//	            for (Useranswer answer : question.getUseranswer()) {
//	                JSONObject answerJson = new JSONObject();
//	                answerJson.put("useranswerid", answer.getUseranswerid());
//	                answerJson.put("answer", answer.getAnswer());
//	                userAnswerArray.add(answerJson);
//	            }
	            questionJson.put("useranswer", userAnswerArray);

	            // Options
	            JSONArray optionsArray = new JSONArray();
	            for (Options option : question.getOptions()) {
	                JSONObject optionJson = new JSONObject();
	                optionJson.put("optid", option.getOptid());
	                optionJson.put("opttext", option.getOpttext());
	                optionsArray.add(optionJson);
	            }
	            questionJson.put("options", optionsArray);

	            sections.get(sectionDesc).add(questionJson);
	        }

	        // Create the final JSON response
	        JSONArray array = new JSONArray();
	        JSONObject jsonResponse = new JSONObject();
	        for (Map.Entry<String, JSONArray> entry : sections.entrySet()) {
	            jsonResponse.put(entry.getKey(), entry.getValue());
	        }
	        array.add(jsonResponse);

	        return array;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new JSONArray();
	    }
	}

    
}

