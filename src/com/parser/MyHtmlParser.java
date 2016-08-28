package com.parser;

import java.util.Stack;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MyHtmlParser {
	private Document document;

	/**
	 * @author mercy
	 * @return 利用jsoup解析页面获取指定值
	 * @param isAttrOrText
	 *            如果采集指定attr则输入attr的值，如果采集text则置为null
	 * @param rule
	 *            为css选择器表达式，仅支持一个rule
	 */
	public Stack<String> parseHtml(String html, String rule, String isAttrOrText) {
		Document doc = null;
		Stack<String> result = new Stack<>();
		if (html != null) {
			doc = Jsoup.parse(html);
			setDocument(doc);
			Elements elements = doc.select(rule);
			System.out.println("parseHtml :　" + elements.size());
			if (elements != null) {
				if (isAttrOrText != null) {
					for (Element element : elements) {
						result.push(element.attr(isAttrOrText));
					}
				} else {
					for (Element element : elements) {
						String str = element.text();
						if (str.length() < 5) {
							result.push(element.html());
							System.out.println("得到元素html");
							System.out.println(element.html());
						} else {
							result.push(str);
							System.out.println("what the fuck: " + str);
						}
					}
				}
			}
		}
		System.out.println("///////////////////////");
		// CrawlerLib.printResult(html, false);
		return result;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

}
