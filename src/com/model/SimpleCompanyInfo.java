package com.model;

public class SimpleCompanyInfo {
	private int companyId;
	private int positionCount;// 职位数量
	private int resumeProcessRate;// 简历即时处理率
	private int resumeProcessTime;// 简历平均处理时间
	private int experienceCount;// 面试评价
	private String city;
	private String detailAddress;
	private String labels;// 福利
	private String industryField;// 公司业务
	private String companySize;
	private String financeStage;// 融资情况
	private String companyProfile;// 公司介绍
	private String lastLoginTime;// 公司hr最近登录时间

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getIndustryField() {
		return industryField;
	}

	public void setIndustryField(String industryField) {
		this.industryField = industryField;
	}

	public String getCompanySize() {
		return companySize;
	}

	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}

	public String getFinanceStage() {
		return financeStage;
	}

	public void setFinanceStage(String financeStage) {
		this.financeStage = financeStage;
	}

	public String getCompanyProfile() {
		return companyProfile;
	}

	public void setCompanyProfile(String companyProfile) {
		this.companyProfile = companyProfile;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public int getPositionCount() {
		return positionCount;
	}

	public void setPositionCount(int positionCount) {
		this.positionCount = positionCount;
	}

	public int getResumeProcessRate() {
		return resumeProcessRate;
	}

	public void setResumeProcessRate(int resumeProcessRate) {
		this.resumeProcessRate = resumeProcessRate;
	}

	public int getResumeProcessTime() {
		return resumeProcessTime;
	}

	public void setResumeProcessTime(int resumeProcessTime) {
		this.resumeProcessTime = resumeProcessTime;
	}

	public int getExperienceCount() {
		return experienceCount;
	}

	public void setExperienceCount(int experienceCount) {
		this.experienceCount = experienceCount;
	}

}
