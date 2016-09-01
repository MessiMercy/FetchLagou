package com.model;

public class SimpleInterviewExperiences {
	private int companyId;
	private int id;
	private String tagArray;
	private String username;
	private String content;
	private String positionName;
	private String positionType;
	private String createTime;
	private int describeScore;// ��������Ǽ�
	private int interviewerScore;// �����Ǽ�
	private int companyScore;// ��˾�Ǽ�

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("������Ϣ��\r\n-------------------------------------------------\r\n");
		result.append("��˾id�� " + companyId + "\r\n");
		result.append("����id�� " + id + "\r\n");
		result.append("���Ա�ǩ�� " + tagArray + "\r\n");
		result.append("�û����� " + username + "\r\n");
		result.append("���ݣ� " + content + "\r\n");
		result.append("ְλ���ƣ� " + positionName + "\r\n");
		result.append("ְλ���ͣ� " + positionType + "\r\n");
		result.append("����ʱ�䣺 " + createTime + "\r\n");
		result.append("��������Ǽ��� " + describeScore + "\r\n");
		result.append("�����Ǽ��� " + interviewerScore + "\r\n");
		result.append("��˾�Ǽ��� " + companyScore + "\r\n");
		result.append("-----------------------------------------\r\n");
		return result.toString();
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getTagArray() {
		return tagArray;
	}

	public void setTagArray(String tagArray) {
		this.tagArray = tagArray;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionType() {
		return positionType;
	}

	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getDescribeScore() {
		return describeScore;
	}

	public void setDescribeScore(int describeScore) {
		this.describeScore = describeScore;
	}

	public int getInterviewerScore() {
		return interviewerScore;
	}

	public void setInterviewerScore(int interviewerScore) {
		this.interviewerScore = interviewerScore;
	}

	public int getCompanyScore() {
		return companyScore;
	}

	public void setCompanyScore(int companyScore) {
		this.companyScore = companyScore;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
