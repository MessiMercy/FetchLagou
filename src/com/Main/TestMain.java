package com.Main;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.downloader.CrawlerLib;
import com.downloader.FetchTargetText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.model.CompanyInfo;
import com.model.InterviewExperience;
import com.model.PositionInfo;
import com.model.SimpleInterviewExperiences;
import com.model.inter.ISimpleInterviewExperiencesOperation;
import com.parser.MyHtmlParser;
import com.pipeline.Filepipeline;
import com.urlFactory.UrlQueue;

public class TestMain {
	@SuppressWarnings("unused")
	private static final String GONGSIURL = "http://www.lagou.com/gongsi/0-0-0";// 全国
	private static final String ZHAOPINURL = "http://www.lagou.com/zhaopin/";
	private static final String GONGSIAJAX = "http://www.lagou.com/gongsi/0-0-0.json";
	private static final String POSITIONURL = "http://www.lagou.com/gongsi/searchPosition.json";
	private static final String SEARCHURL = "http://www.lagou.com/jobs/companyAjax.json";
	public static HashMap<String, String> map = new HashMap<>();
	// private CrawlerLib lib;
	private static final HttpClient CLIENT = CrawlerLib.getInstanceClient(false);
	private static final String CHARSET = "UTF-8";
	// private static final Stack<Integer> companyIdStore = new Stack<>();
	private static final UrlQueue queue = new UrlQueue();
	private static SqlSessionFactory factory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("Configuration.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getFactory() {
		return factory;
	}

	public static void main(String[] args) {

	}

	public static void search() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入你需要查找的公司名字");
		String keyWord = scanner.nextLine();
		String resultAjax = getSearchCompany(keyWord);
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(resultAjax);
		JsonElement contentElement = element.getAsJsonObject().get("content");
		System.out.println("总共查询到" + contentElement.getAsJsonObject().get("totalCount").getAsInt() + "个结果");
		JsonArray array = contentElement.getAsJsonObject().get("result").getAsJsonArray();
		for (JsonElement jsonElement : array) {
			int companyID = jsonElement.getAsJsonObject().get("companyId").getAsInt();
			queue.put(companyID, false);
		}
		Filepipeline pipe = new Filepipeline();
		pipe.printResult(resultAjax, false, "resultAjax.txt");
		scanner.close();
	}

	public static void func() {
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
			String companyUrl = getCompanyUrl(Integer.valueOf(string));
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
			pipe.printResult(interviewJson, true, "interviewExperiencesData");// 打印面试信息
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 在拉勾全国分类下返回公司信息ajax
	 * 
	 * @param pageNum
	 *            最多为20页
	 */
	public static String getCompanyAjax(int pageNum) {
		HashMap<String, String> headersMap = new HashMap<>();
		headersMap.put("Referer", "http://www.lagou.com/gongsi/0-0-0");
		headersMap.put("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
		headersMap.put("X-Requested-With", "XMLHttpRequest");
		headersMap.put("X-Anit-Forge-Token", "None");
		headersMap.put("X-Anit-Forge-Code", "0");
		List<NameValuePair> list = new ArrayList<>();
		list.add(new BasicNameValuePair("first", "false"));
		list.add(new BasicNameValuePair("pn", pageNum + ""));
		list.add(new BasicNameValuePair("sortField", "0"));
		list.add(new BasicNameValuePair("havemark", "0"));
		String result = FetchTargetText.postEntity(CLIENT, GONGSIAJAX, list, null, headersMap, CHARSET);
		return result;// 结果在result的array下，详情见抓取指南。可以此获取companyID
	}

	/** 通过companyId得到公司面试评价信息，和公司信息，部分公司没有评价 string[0]为评价信息，string[1]为公司信息 */
	public static String[] getCompanyAndInterView(int companyId) {
		String[] result = new String[2];
		String companyUrl = getCompanyUrl(companyId);
		String companyDetailHtml = FetchTargetText.getEntity(CLIENT, companyUrl, map, CHARSET);
		Document doc = Jsoup.parse(companyDetailHtml);
		try {
			result[0] = doc.select("#interviewExperiencesData").first().html();
			result[1] = doc.select("#companyInfoData").first().html();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	/**
	 * 用于传入companyid得到公司职位信息而组成post的表单。
	 */
	public static List<NameValuePair> getPostDict(String companyId) {
		List<NameValuePair> postDict = new ArrayList<>();
		System.out.println("****************" + companyId + "***************");
		postDict.add(new BasicNameValuePair("companyId", companyId));
		postDict.add(new BasicNameValuePair("positionFirstType", "全部"));
		postDict.add(new BasicNameValuePair("pageNo", "1"));
		postDict.add(new BasicNameValuePair("pageSize", "50"));
		return postDict;
	}

	/**
	 * 用于传入companyId，得到公司招聘职位信息
	 */
	public static String getCompanyPositionInfo(String companyId) {
		HashMap<String, String> map = new HashMap<>();
		map.put("Referer", "http://www.lagou.com/");
		map.put("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
		List<NameValuePair> postDict = getPostDict(companyId);
		String positionJson = FetchTargetText.postEntity(CLIENT, POSITIONURL, postDict, null, map, CHARSET);
		return positionJson;

	}

	/**
	 * 通过companyId组装公司详情页
	 */
	public static String getCompanyUrl(int companyId) {
		return "http://www.lagou.com/gongsi/" + companyId + ".html";
	}

	/**
	 * 通过传入公司名，获取返回json,默认地址为成都.搜索结果在content.result数组下，具体参见爬取指南
	 */
	public static String getSearchCompany(String keyWord) {
		String defaultUrl = SEARCHURL + "?city=%E6%88%90%E9%83%BD&needAddtionalResult=false";
		map.put("Referer",
				"http://www.lagou.com/jobs/list_%E5%BD%93%E4%B9%90?city=%E6%88%90%E9%83%BD&cl=false&fromSearch=true&labelWords=&suginput=");
		List<NameValuePair> list = new ArrayList<>();
		list.add(new BasicNameValuePair("first", "true"));
		list.add(new BasicNameValuePair("pn", "1"));
		list.add(new BasicNameValuePair("kd", keyWord));
		String resultJson = FetchTargetText.postEntity(CLIENT, defaultUrl, list, null, map, CHARSET);
		return resultJson;

	}

	public static void test() {
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

	public static void storeAllDetails(int companyId) {
		String[] companyAndInterView = getCompanyAndInterView(companyId);
		String interViewInfo = companyAndInterView[0];
		String companyInfo = companyAndInterView[1];
		List<SimpleInterviewExperiences> list = getInterview(interViewInfo);

	}

	public static List<SimpleInterviewExperiences> getInterview(String interviewJson) {
		List<SimpleInterviewExperiences> list = new ArrayList<>();
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(interviewJson);
		JsonArray array = element.getAsJsonObject().get("result").getAsJsonArray();
		Gson gson = new Gson();
		for (JsonElement jsonElement : array) {
			SimpleInterviewExperiences experience = gson.fromJson(jsonElement, SimpleInterviewExperiences.class);
			list.add(experience);
		}
		return list;
	}

	public static void sqlTest() {
		SqlSession session = factory.openSession();
		ISimpleInterviewExperiencesOperation operation = session.getMapper(ISimpleInterviewExperiencesOperation.class);
		SimpleInterviewExperiences interview = new SimpleInterviewExperiences();
		interview.setCompanyId(8080);
		interview.setCompanyScore(5);
		interview.setContent("adasc测试测试");
		interview.setUsername("呵呵");
		operation.addInterview(interview);
		session.commit();
		SimpleInterviewExperiences in = operation.selectInterviewByID(8080);
		System.out.println(in.getCompanyId());
		System.out.println(in.getContent());
		session.close();
	}
}
