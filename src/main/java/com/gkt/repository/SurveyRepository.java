package com.gkt.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gkt.dto.SurveyDTO;
import com.gkt.model.Coursequiz;
import com.gkt.model.Section;
import com.gkt.model.Survey;


public interface SurveyRepository extends JpaRepository<Survey,Long> {

//	@Query(value = "SELECT * FROM survey", nativeQuery = true)
//	List<Survey> getsurveydata();

	
	@Query(value = " select survey.*,section.*,count(quizid) as questions from survey inner join section on id = survey_id inner join coursequiz on section.sectionid = coursequiz.sectionid group by coursequiz.sectionid;", nativeQuery = true)
	List<SurveyDTO> getsurveydata();
	
	
    @Query("SELECT s.timeToComplete FROM Survey s WHERE s.id = :surveyId")
    Integer findTimeToCompleteById(@Param("surveyId") Long surveyId);


    

	
	

	


	

}
