package com.model;

public class SimpleCompanyInfo {
	private int companyId;
	private int positionCount;// ְλ����
	private int resumeProcessRate;// ������ʱ������
	private int resumeProcessTime;// ����ƽ������ʱ��
	private int experienceCount;// ��������
	private String city;
	private String detailAddress;
	private String labels;// ����
	private String industryField;// ��˾ҵ��
	private String companySize;
	private String financeStage;// �������
	private String companyProfile;// ��˾����
	private String lastLoginTime;// ��˾hr�����¼ʱ��

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
