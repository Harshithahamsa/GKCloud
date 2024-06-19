package com.gkt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.gkt.model.Coursequiz;

public interface CourseQuizRepository extends JpaRepository<Coursequiz,Long> {


	@Query(value = "SELECT * FROM coursequiz cq INNER JOIN section s ON cq.section_desc = s.section_desc", nativeQuery = true)
	List<Coursequiz> getsurveydata();


	
}
