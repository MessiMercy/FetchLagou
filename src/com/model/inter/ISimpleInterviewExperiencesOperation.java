package com.model.inter;

import com.model.SimpleInterviewExperiences;

public interface ISimpleInterviewExperiencesOperation {
	public SimpleInterviewExperiences selectInterviewByID(int companyId);

	public void addInterview(SimpleInterviewExperiences simpleInterviewExperiences);

	public void deleteSimpleInterviewExperiences(int companyId);
}
