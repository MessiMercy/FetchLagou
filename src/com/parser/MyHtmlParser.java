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
	 * @return ����jsoup����ҳ���ȡָ��ֵ
	 * @param isAttrOrText
	 *            ����ɼ�ָ��attr������attr��ֵ������ɼ�text����Ϊnull
	 * @param rule
	 *            Ϊcssѡ�������ʽ����֧��һ��rule
	 */
	public Stack<String> parseHtml(String html, String rule, String isAttrOrText) {
		Document doc = null;
		Stack<String> result = new Stack<>();
		if (html != null) {
			doc = Jsoup.parse(html);
			setDocument(doc);
			Elements elements = doc.select(rule);
			System.out.println("parseHtml :��" + elements.size());
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
							System.out.println("�õ�Ԫ��html");
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
