package com.model;

public class SimplePositionInfo {
	private int companyId;
	private int positionId;
	private String jobNature;// ȫְ��ְ
	private String financeStage;// �������
	private String companyName;
	private String companyFullName;
	private String industryField;
	private String positionName;
	private String city;
	private String createTime;
	private String salary;
	private String workYear;
	private String education;
	private String positionAdvantage;
	private String district;

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("ְλ��Ϣ��\r\n-------------------------------------------------\r\n");
		result.append("��˾id�� " + companyId + "\r\n");
		result.append("ְλid�� " + positionId + "\r\n");
		result.append("ȫְ��ְ�� " + jobNature + "\r\n");
		result.append("��������� " + financeStage + "\r\n");
		result.append("��˾���֣� " + companyName + "\r\n");
		result.append("���ڳ��У� " + city + "\r\n");
		result.append("��˾ȫ�ƣ� " + companyFullName + "\r\n");
		result.append("��˾ҵ�� " + industryField + "\r\n");
		result.append("ְλ���ƣ� " + positionName + "\r\n");
		result.append("��������� " + financeStage + "\r\n");
		result.append("����ʱ�䣺 " + createTime + "\r\n");
		result.append("���ʣ� " + salary + "\r\n");
		result.append("�������飺 " + workYear + "\r\n");
		result.append("��������� " + education + "\r\n");
		result.append("ְλ���ƣ� " + positionAdvantage + "\r\n");
		result.append("���� " + district + "\r\n");
		result.append("-----------------------------------------\r\n");
		return result.toString();
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public String getJobNature() {
		return jobNature;
	}

	public void setJobNature(String jobNature) {
		this.jobNature = jobNature;
	}

	public String getFinanceStage() {
		return financeStage;
	}

	public void setFinanceStage(String financeStage) {
		this.financeStage = financeStage;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyFullName() {
		return companyFullName;
	}

	public void setCompanyFullName(String companyFullName) {
		this.companyFullName = companyFullName;
	}

	public String getIndustryField() {
		return industryField;
	}

	public void setIndustryField(String industryField) {
		this.industryField = industryField;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getWorkYear() {
		return workYear;
	}

	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPositionAdvantage() {
		return positionAdvantage;
	}

	public void setPositionAdvantage(String positionAdvantage) {
		this.positionAdvantage = positionAdvantage;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

}
