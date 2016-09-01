package com.model;

public class SimpleCompanyInfo {
	private int companyId;
	private int positionCount;// ְλ����
	private int resumeProcessRate;// ������ʱ������
	private int resumeProcessTime;// ����ƽ������ʱ��
	private int experienceCount;// ����������
	private String city;
	private String detailAddress;
	private String industryField;// ��˾ҵ��
	private String companySize;
	private String financeStage;// �������
	private String companyProfile;// ��˾����
	private String lastLoginTime;// ��˾hr�����¼ʱ��

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("��˾��Ϣ��\r\n-------------------------------------------------\r\n");
		result.append("��˾id�� " + companyId + "\r\n");
		result.append("ְλ������ " + positionCount + "\r\n");
		result.append("������ʱ�����ʣ� " + resumeProcessRate + "\r\n");
		result.append("����ƽ������ʱ�䣺 " + resumeProcessTime + "\r\n");
		result.append("������������ " + experienceCount + "\r\n");
		result.append("���ڳ��У� " + city + "\r\n");
		result.append("�����ַ�� " + detailAddress + "\r\n");
		result.append("��˾ҵ�� " + industryField + "\r\n");
		result.append("��˾������ " + companySize + "\r\n");
		result.append("��������� " + financeStage + "\r\n");
		result.append("��˾���ܣ� " + companyProfile + "\r\n");
		result.append("��˾hr�����¼ʱ�䣺 " + lastLoginTime + "\r\n");
		result.append("-----------------------------------------\r\n");
		return result.toString();
	}

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
