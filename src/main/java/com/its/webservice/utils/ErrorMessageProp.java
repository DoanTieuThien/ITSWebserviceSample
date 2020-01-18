package com.its.webservice.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class ErrorMessageProp {
	private ConcurrentHashMap<String, String> errorMessageMap = null;

	public ErrorMessageProp(String fileName) {
		FileInputStream input = null;
		try {
			this.errorMessageMap = new ConcurrentHashMap<String, String>();
			Properties prop = new Properties();
			input = new FileInputStream(new File(fileName));
			prop.load(new InputStreamReader(input, Charset.forName("UTF-8")));
			this.errorMessageMap.putAll((Map)prop);
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String getValue(String key) {
		String data = "";
		if(key == null || key.equals("")) {
			return data;
		}
		if(this.errorMessageMap == null) {
			return data;
		}
		if(this.errorMessageMap.containsKey(key)) {
			data = this.errorMessageMap.get(key).trim();
		}
		return data;
	}
}
