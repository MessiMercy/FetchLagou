package com.parser;

import java.io.StringReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class MyJsonParser {
	private JsonObject obj;

	public void parseFunc(String json) {
		StringReader reader = new StringReader(json);
		JsonParser parser = new JsonParser();
		JsonReader Jreader = new JsonReader(reader);
		Jreader.setLenient(true);
		JsonElement element = parser.parse(Jreader);
		setObj(element.getAsJsonObject());
	}

	public JsonObject getObj() {
		return obj;
	}

	public void setObj(JsonObject obj) {
		this.obj = obj;
	}

}
