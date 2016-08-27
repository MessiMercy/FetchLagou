package com.Main;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.downloader.CrawlerLib;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.model.CompanyInfo;
import com.model.InterviewExperience;
import com.model.PositionInfo;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String job = "{'labels': ['��Ч����','��н���','ר���','��������','˧���','����淶','������ѵ','�쵼��','�������'],'baseInfo': {'companyId': 45496,'industryField': '����,��ҵ����','companySize': '2000������','city': '�ɶ�','financeStage': 'δ����'},'leaders': [],'userType': false,'history': [],'pageType': 1,'coreInfo': {'companyId': 45496,'logo': 'i/image/M00/03/DC/Cgp3O1bEFraAThpjAAATlD6XITM677.jpg','companyName': '�ɶ����ҷ��ز��������޹�˾','companyShortName': '����','approve': 0,'companyUrl': '','companyIntroduce': 'ѡ�����ң�ѡ��ɹ�','isFirst': false},'dataInfo': {'positionCount': 7,'resumeProcessRate': 92,'resumeProcessTime': 2,'experienceCount': 4,'lastLoginTime': '����'},'companyId': 45496,'products': [],'introduction': {'companyId': 45496,'companyProfile': '���ҳ�����2001�꣬Ŀǰ�Ѹ��Ǳ������Ϻ������ڡ����졢����������Ͼ����ɶ����ൺ�����ݵ�29�����У��ŵ�Լ6000�ң����¾����˳���5������2015�꽻�׶�Ԥ�ƽ���4000��Ԫ��\n<br />�ɶ�������2011��10����ʽ��פ�ɶ����Գɶ��ж��ַ����������ޡ��·���������ҵ�ز������ڰ��ҷ���Ϊ������ֹ2015��12�³ɶ������ŵ�����500��ң���������Ϊ�й���������ز����͵ĺ���ĸ����','pictures': []},'isCompanyHr': false}";
		Type type = new TypeToken<CompanyInfo>() {
		}.getType();
		Gson gson = new GsonBuilder().create();
		// gson.getAdapter(coreInfo.class);
		CompanyInfo info = gson.fromJson(job, type);
		JsonElement parser = new JsonParser().parse(job);
		String conpanyName = parser.getAsJsonObject().get("coreInfo").getAsJsonObject().get("companyName")
				.getAsString();
		System.out.println(conpanyName);
		System.out.println(info.getCoreInfo().getCompanyName());
		System.out.println(info.getIntroduction().getCompanyProfile());
		System.out.println(info.getCompanyIntroduce());
		String[] labels = info.getLabels();
		for (String string : labels) {
			System.out.println(string);
		}

		CompanyInfo info2 = new CompanyInfo();
		InterviewExperience experience = new InterviewExperience();
		PositionInfo positionInfo = new PositionInfo();
		info2.setCity("�ɶ�");
		info2.setCompanyProfile("ɷ������");
		info2.setCompanyName("����");
		positionInfo.setCompanyFullName("���ֿƼ����޹�˾");
		positionInfo.setCompanyName("����");
		positionInfo.setCity("�ɶ�");
		positionInfo.setCompanySize("200+");
		positionInfo.setDistrict("������");
		experience.setCompanyName("����");
		experience.setCompanyScore(1);
		experience.setContent("�쵼��ɷ��");
		experience.setMyScore(1);
		experience.setPositionName("Сආ�");
		List<PositionInfo> positionInfos = new ArrayList<>();
		List<InterviewExperience> interviewExperiences = new ArrayList<>();
		positionInfos.add(positionInfo);
		interviewExperiences.add(experience);
		info2.setPositionInfos(positionInfos);
		info2.setInterviewExperiences(interviewExperiences);
		String myJson = new Gson().toJson(info2, CompanyInfo.class);
		CrawlerLib.printResult(myJson, true);
	}

}
