package com.Main;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.downloader.CrawlerLib;
import com.downloader.FetchTargetText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.model.CompanyInfo;
import com.model.InterviewExperience;
import com.model.PositionInfo;
import com.parser.MyHtmlParser;
import com.pipeline.Filepipeline;

public class TestMain {
	private static final String ZHAOPINURL = "http://www.lagou.com/zhaopin/";
	private static final String POSITIONURL = "http://www.lagou.com/gongsi/searchPosition.json";
	// private CrawlerLib lib;
	private static final HttpClient CLIENT = CrawlerLib.getInstanceClient(false);
	private static final String CHARSET = "UTF-8";

	public static void main(String[] args) {
		// try {
		// Document doc =
		// Jsoup.connect("http://www.lagou.com/gongsi/76648.html")
		// .data("User-Agent",
		// "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like
		// Gecko) Chrome/52.0.2743.116 Safari/537.36")
		// .get();
		// Elements elements = doc.select("#interviewExperiencesData");
		// System.out.println(elements.size());
		// String text = elements.first().html();
		// // CrawlerLib.printResult(doc.html(), true);
		// System.out.println(doc.title());
		// System.out.println(text);
		// // for (Element element : elements) {
		// // System.out.println(element.attr("data-companyid"));
		// // }
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// try {
		// Document doc = Jsoup.connect(POSITIONURL).data("companyId",
		// "76648").data("positionFirstType", "全部")
		// .data("pageNo", "1").data("pageSize", "10").post();
		// System.out.println(doc.html());
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		func();
	}

	public static void func() {
		HashMap<String, String> map = new HashMap<>();
		Filepipeline pipe = new Filepipeline();
		map.put("Referer", "http://www.lagou.com/");
		map.put("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
		String zhaopinHtml = FetchTargetText.getEntity(CLIENT, ZHAOPINURL, map, CHARSET);
		MyHtmlParser parser = new MyHtmlParser();
		Stack<String> companyidStack = parser.parseHtml(zhaopinHtml, "li.con_list_item", "data-companyid");
		System.out.println(companyidStack.size() + ": " + companyidStack.peek());
		for (String string : companyidStack) {
			System.out.println("processing: " + string);
			String companyUrl = getCompanyUrl(string);
			String companyDetailHtml = FetchTargetText.getEntity(CLIENT, companyUrl, map, CHARSET);
			System.out.println("companyDetailHtml`s length: " + companyDetailHtml.length());
			// CrawlerLib.printResult(companyDetailHtml, true);
			MyHtmlParser parser2 = new MyHtmlParser();
			String detailJson = parser2.parseHtml(companyDetailHtml, "#companyInfoData", null).pop();
			String interviewJson = null;
			try {
				interviewJson = parser2.getDocument().select("#interviewExperiencesData").first().html();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			List<NameValuePair> postDict = getPostDict(string);
			String positionJson = FetchTargetText.postEntity(CLIENT, POSITIONURL, postDict, null, map, CHARSET);
			pipe.printResult(detailJson, true, "companyInfoData");// 打印公司detail
			pipe.printResult(positionJson, true, "PositionInfo");// 打印职位detail
			pipe.printResult(interviewJson, true, "interviewExperiencesData");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<NameValuePair> getPostDict(String companyId) {
		List<NameValuePair> postDict = new ArrayList<>();
		System.out.println("****************" + companyId + "***************");
		postDict.add(new BasicNameValuePair("companyId", companyId));
		postDict.add(new BasicNameValuePair("positionFirstType", "全部"));
		postDict.add(new BasicNameValuePair("pageNo", "1"));
		postDict.add(new BasicNameValuePair("pageSize", "10"));
		return postDict;
	}

	public static String getCompanyUrl(String companyId) {
		return "http://www.lagou.com/gongsi/" + companyId + ".html";
	}

	public static void test() {
		// TODO Auto-generated method stub
		String job = "{'labels': ['绩效奖金','带薪年假','专项奖金','节日礼物','帅哥多','管理规范','技能培训','领导好','年度旅游'],'baseInfo': {'companyId': 45496,'industryField': '其他,企业服务','companySize': '2000人以上','city': '成都','financeStage': '未融资'},'leaders': [],'userType': false,'history': [],'pageType': 1,'coreInfo': {'companyId': 45496,'logo': 'i/image/M00/03/DC/Cgp3O1bEFraAThpjAAATlD6XITM677.jpg','companyName': '成都链家房地产经纪有限公司','companyShortName': '链家','approve': 0,'companyUrl': '','companyIntroduce': '选择链家，选择成功','isFirst': false},'dataInfo': {'positionCount': 7,'resumeProcessRate': 92,'resumeProcessTime': 2,'experienceCount': 4,'lastLoginTime': '今天'},'companyId': 45496,'products': [],'introduction': {'companyId': 45496,'companyProfile': '链家成立于2001年，目前已覆盖北京、上海、深圳、重庆、大连、天津、南京、成都、青岛、杭州等29个城市，门店约6000家，旗下经纪人超过5万名，2015年交易额预计将达4000亿元。\n<br />成都链家于2011年10月正式进驻成都，以成都市二手房买卖、租赁、新房分销、商业地产、金融按揭服务为主，截止2015年12月成都链家门店已有500余家，着力打造为中国西南区域地产经纪的航空母舰！','pictures': []},'isCompanyHr': false}";
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
		info2.setCity("成都");
		info2.setCompanyProfile("速来");
		info2.setCompanyName("当乐");
		positionInfo.setCompanyFullName("当乐科技有限公司");
		positionInfo.setCompanyName("当乐");
		positionInfo.setCity("成都");
		positionInfo.setCompanySize("200+");
		positionInfo.setDistrict("高新区");
		experience.setCompanyName("当乐");
		experience.setCompanyScore(1);
		experience.setContent("领导");
		experience.setMyScore(1);
		experience.setPositionName("小喽啰");
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
