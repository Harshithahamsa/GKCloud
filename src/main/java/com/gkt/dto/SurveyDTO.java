package com.gkt.dto;

public interface SurveyDTO {
	int getid();
    String getsurvey_type();
    Boolean gettime_based();
    int gettime_to_complete();
    long getsectionid();
    String getbg_color();
    String getcolor();
    int getnumber_of_questions();
    String getsection_desc();
    int gettab_order();
    int getsurvey_id();
    int getquestions();
}
