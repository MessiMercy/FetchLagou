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
