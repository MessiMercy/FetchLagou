package com.model.inter;

import java.util.List;

import com.model.SimpleInterviewExperiences;

public interface ISimpleInterviewExperiencesOperation {
	public List<SimpleInterviewExperiences> selectInterviewByID(int companyId);

	public void addInterview(SimpleInterviewExperiences simpleInterviewExperiences);

	public void deleteSimpleInterviewExperiences(int companyId);

	public List<SimpleInterviewExperiences> selectCompanyInterviews(int companyId);

}
