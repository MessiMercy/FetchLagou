package com.Main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.imageio.ImageIO;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.MainImage;
import com.downloader.CrawlerLib;
import com.downloader.FetchTargetText;
import com.pipeline.Filepipeline;

public class ShiXinCrawler {
	private static final HttpClient CLIENT = CrawlerLib.getInstanceClient(false);
	private static final String IMAGEURL = "http://shixin.court.gov.cn/image.jsp";// 验证码接口
	private static final String SEARCHURL = "http://shixin.court.gov.cn/findd";// 搜索接口
	private static final String DETAILURL = "http://shixin.court.gov.cn/findDetai";// 文书具体内容
	private static final String PUBLISHURL = "http://shixin.court.gov.cn/index_publish_new.jsp";// 失信人公示
	private static HashMap<String, String> map = new HashMap<>();

	public static void main(String[] args) {
		// BufferedImage image = null;
		// try {
		// image = ImageIO.read(new File("1.jpg"));
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// String str = MainImage.shiXinImageFigure(image);
		// System.out.println(str);
		// map.put("Referer",
		// "http://www.yingjiesheng.com/commend-fulltime-5.html");
		map.put("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
		map.put("Referer", "http://shixin.court.gov.cn/");
		searchShiXin("杨乃义", null, 0);
		// Properties pp = new Properties();
		// try {
		// Document document =
		// Jsoup.connect("http://shixin.court.gov.cn/").userAgent(map.get("User-Agent")).get();
		// Elements elements = document.select("#pProvince option");
		// for (Element element : elements) {
		// pp.setProperty(element.attr("value"), element.text());
		// System.out.println(element.attr("value") + ": " + element.text());
		// }
		// pp.store(new FileWriter(new File("province.properties")), "test");
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

	public static String getDetail(int id, String pCode) {
		String resultJson = null;
		String targetUrl = DETAILURL + "?id=" + id + "&pCode=" + pCode;
		// map.put("X-Requested-With", "XMLHttpRequest");
		// map.put("Accept-Encoding", "gzip, deflate, sdch");
		resultJson = FetchTargetText.getEntity(CLIENT, targetUrl, map);
		return resultJson;
	}

	/**
	 * @param pName
	 *            为名字关键字，需要两个以上汉字
	 * @param pCardNum
	 *            身份证号码，或者组织机构号码
	 * @param pProvince
	 *            省份代码，0为全国。各省份代码在province.properties中
	 */
	public static void searchShiXin(String pName, String pCardNum, int pProvince) {
		String pCode = picOcr();
		List<NameValuePair> postDict = new ArrayList<>();
		postDict.add(new BasicNameValuePair("pName", pName));
		postDict.add(new BasicNameValuePair("pCardNum", pCardNum));
		postDict.add(new BasicNameValuePair("pProvince", pProvince + ""));
		postDict.add(new BasicNameValuePair("pCode", pCode));
		System.out.println("验证码: " + pCode);
		String html = FetchTargetText.postEntity(CLIENT, SEARCHURL, postDict, null, map, "utf-8");
		Document doc = Jsoup.parse(html);
		Elements elements = doc.select("tr[style]");
		for (Element element : elements) {
			String id = element.select("a.View").first().attr("id");
			System.out.println(element.text() + " " + id);
			System.out.println("------------------------");
			String detail = getDetail(Integer.valueOf(id), pCode);
			System.out.println(detail);
		}

		new Filepipeline().printResult(html, false, "shixin.txt");
		System.out.println(doc.title());
	}

	public static String picOcr() {
		Calendar cd = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d yyyy HH:mm:ss 'GMT'", Locale.US);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+8")); // 设置时区为GMT
		String str = sdf.format(cd.getTime());
		try {
			str = URLEncoder.encode(str, "utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		InputStream in = FetchTargetText.downloadEntity(CLIENT, IMAGEURL + "?date=" + str, map, "utf-8");
		BufferedImage image = null;
		try {
			image = ImageIO.read(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String pCode = MainImage.shiXinImageFigure(image);
		return pCode;
	}

}
