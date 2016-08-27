package com.model;

import java.util.List;

public class CompanyInfo {
	private int companyId;
	private introduction introduction;
	private coreInfo coreInfo;
	private dataInfo dataInfo;
	private String[] products;
	private String companyName;
	private String companyShortName;
	private String companyUrl;
	@SuppressWarnings("unused")
	private String companyIntroduce;
	private String companyProfile;
	private String companySize;
	private String city;
	private String industryField;
	/** ���������� */
	private int resumeProcessRate;
	/** ���������ʱ */
	private int resumeProcessTime;
	/** ������������ */
	private int experienceCount;
	@SuppressWarnings("unused")
	private String lastLoginTime;

	/** ������� */
	private String financeStage;
	/** ��˾���� */
	private String[] labels;
	/** �������� */
	private List<InterviewExperience> interviewExperiences;
	/** ��Ƹְλ��Ϣ */
	private List<PositionInfo> positionInfos;
	/** ��Ƹְλ�� */
	private int positionCount;

	public String getIndustryField() {
		return industryField;
	}

	public void setIndustryField(String industryField) {
		this.industryField = industryField;
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

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String[] getProducts() {
		return products;
	}

	public void setProducts(String[] products) {
		this.products = products;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyShortName() {
		return companyShortName;
	}

	public void setCompanyShortName(String companyShortName) {
		this.companyShortName = companyShortName;
	}

	public String getCompanyUrl() {
		return companyUrl;
	}

	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}

	public String getCompanyIntroduce() {
		return getCoreInfo().getCompanyIntroduce();
	}

	public void setCompanyIntroduce(String companyIntroduce) {
		this.companyIntroduce = companyIntroduce;
	}

	public String getLastLoginTime() {
		return getDataInfo().getLastLoginTime();
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getCompanyProfile() {
		return companyProfile;
	}

	public void setCompanyProfile(String companyProfile) {
		this.companyProfile = companyProfile;
	}

	public String getCompanySize() {
		return companySize;
	}

	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFinanceStage() {
		return financeStage;
	}

	public void setFinanceStage(String financeStage) {
		this.financeStage = financeStage;
	}

	public String[] getLabels() {
		return labels;
	}

	public void setLabels(String[] labels) {
		this.labels = labels;
	}

	public List<InterviewExperience> getInterviewExperiences() {
		return interviewExperiences;
	}

	public void setInterviewExperiences(List<InterviewExperience> interviewExperiences) {
		this.interviewExperiences = interviewExperiences;
	}

	// public String companyName() {
	// return getInfo().getCompanyName();
	// }

	public coreInfo getCoreInfo() {
		return coreInfo;
	}

	public void setCoreInfo(coreInfo coreInfo) {
		this.coreInfo = coreInfo;
	}

	public introduction getIntroduction() {
		return introduction;
	}

	public void setIntroduction(introduction introduction) {
		this.introduction = introduction;
	}

	public dataInfo getDataInfo() {
		return dataInfo;
	}

	public void setDataInfo(dataInfo dataInfo) {
		this.dataInfo = dataInfo;
	}

	public List<PositionInfo> getPositionInfos() {
		return positionInfos;
	}

	public void setPositionInfos(List<PositionInfo> positionInfos) {
		this.positionInfos = positionInfos;
	}

	public static class coreInfo {
		private String companyId;
		private String companyName;
		private String companyShortName;
		private String companyIntroduce;

		public String getCompanyId() {
			return companyId;
		}

		public void setCompanyId(String companyId) {
			this.companyId = companyId;
		}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getCompanyShortName() {
			return companyShortName;
		}

		public void setCompanyShortName(String companyShortName) {
			this.companyShortName = companyShortName;
		}

		public String getCompanyIntroduce() {
			return companyIntroduce;
		}

		public void setCompanyIntroduce(String companyIntroduce) {
			this.companyIntroduce = companyIntroduce;
		}

	}

	public static class introduction {
		private int companyId;
		private String companyProfile;

		public int getCompanyId() {
			return companyId;
		}

		public void setCompanyId(int companyId) {
			this.companyId = companyId;
		}

		public String getCompanyProfile() {
			return companyProfile;
		}

		public void setCompanyProfile(String companyProfile) {
			this.companyProfile = companyProfile;
		}
	}

	public static class baseInfo {
		private String industryField;
		private String companySize;
		private String city;
		private String financeStage;

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

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getFinanceStage() {
			return financeStage;
		}

		public void setFinanceStage(String financeStage) {
			this.financeStage = financeStage;
		}

	}

	public static class dataInfo {
		/** ��Ƹְλ�� */
		private int positionCount;
		/** ���������� */
		private int resumeProcessRate;
		/** ���������ʱ */
		private int resumeProcessTime;
		/** ������������ */
		private int experienceCount;
		private String lastLoginTime;

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

		public String getLastLoginTime() {
			return lastLoginTime;
		}

		public void setLastLoginTime(String lastLoginTime) {
			this.lastLoginTime = lastLoginTime;
		}

	}

}
