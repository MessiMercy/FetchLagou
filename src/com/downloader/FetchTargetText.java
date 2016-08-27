package com.downloader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class FetchTargetText {

	public static String getEntity(HttpClient client, String url, HashMap<String, String> headers, String charset) {
		// StringBuilder result = new StringBuilder();
		HttpGet get = new HttpGet(url);
		if (charset == null) {
			charset = "UTF-8";
		}
		if (headers != null && !headers.isEmpty()) {
			Iterator<Entry<String, String>> iterator = headers.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, String> entry = iterator.next();
				get.setHeader(entry.getKey(), entry.getValue());
			}
		}
		RequestConfig.Builder config = RequestConfig.custom().setConnectTimeout(10 * 1000).setSocketTimeout(5 * 1000);
		get.setConfig(config.build());
		System.out.println("--------------------");
		HttpResponse response = null;
		String html = null;
		try {
			response = client.execute(get);
			System.out.println("++++++++++++++++++++++");
			html = EntityUtils.toString(response.getEntity(), charset);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			html = "error";
			System.out.println("获取" + url + "错误" + "\r\n");
			e.printStackTrace();
		} finally {
			get.abort();
			System.out.println("*****************");
		}
		return html;
	}

	public static String postEntity(HttpClient client, String url, List<BasicNameValuePair> list, String json,
			HashMap<String, String> headers, String charset) {
		HttpPost post = new HttpPost(url);
		if (charset == null) {
			charset = "UTF-8";
		}
		if (headers != null && !headers.isEmpty()) {
			Iterator<Entry<String, String>> iterator = headers.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, String> entry = iterator.next();
				post.setHeader(entry.getKey(), entry.getValue());
			}
		}
		StringEntity jsonEntity = null;
		if (json != null) {
			jsonEntity = new StringEntity(json, charset);
			post.setEntity(jsonEntity);
		} else {
			UrlEncodedFormEntity entity = null;
			try {
				entity = new UrlEncodedFormEntity(list, charset);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			post.setEntity(entity);
		}
		String result = null;
		HttpResponse response = null;
		try {
			response = client.execute(post);
			System.out.println("-----------------");
			result = EntityUtils.toString(response.getEntity(), charset);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("获取" + url + "错误");
			result = "error";
		} finally {
			post.abort();
			System.out.println("****************");
		}
		return result;
	}

}
