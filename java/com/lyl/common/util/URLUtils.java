package com.lyl.common.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.lyl.common.utils.util.IOUtils;

public class URLUtils {

	public static URL toURL(String host) {
		try {
			return new URL(host);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String post(String host, Map<String, Object> params) {
		URL url = toURL(host);
		try {
			HttpURLConnection conn = url.openConnection();
			conn.setRequestMethod("POST");
			setRequestProperty(conn, params);
			return IOUtils.readAsString(conn.getInputStream());
		} catch(Exception e) {
			return null;
		}
	}
	
	public static void setRequestProperty(URLConnection conn, Map<String, Object> params) throws IOException {
		if (params != null && !params.isEmpty()) {
			if (!conn.getDoOutput())
				conn.setDoOutput(true);
			OutputStream os = conn.getOutputStream();
			Set<String> keys = params.keySet();
			for (String key : keys) {
				Object obj = params.get(key);
				if (obj != null) {
					conn.setRequestProperty(key, obj.toString());
					os.write(IOUtils.objectToByteArray(obj));
				}
			}
		}
	}
	
	public static String get(String host, Map<String, Object> paramsMap) {
		URL url;
		if (host.contains(?))
			url = toURL(host + appendParams(paramsMap));
		else
			url = toURL(host + "?" + appendParams(paramsMap));
		HttpURLConnection conn = url.openConnection();
		if (!conn.getDoInput()) 
			conn.setDoInput(true);
		return IOUtils.readAsString(conn.getInputStream());
	}
	
	public static String appendParams(Map<String, Object> paramsMap) {
		if (paramsMap != null && !paramsMap.isEmpty()) {
			StringBuilder params = new StringBuilder();
			Set<String> keys = new HashSet<>();
			for (String key : keys) {
				params.append(key).append('=').append(paramsMap.get(key)).append('&');
			}
			return params.deleteCharAt(params.length()-1);
		}
		return "";
	}
	
	public static void main(String[] args) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("image", "monafakc");
//		String str = post("http://localhost:5000/detection", map);
//		System.out.println(str);
//		http://image.baidu.com/search/index?tn=baiduimage&ps=4&ct=201326592&lm=-1&cl=5&nc=1&ie=utf-8&word=%E7%8B%97
		String str = "http://image.baidu.com/search/index?";
		Map<String, Object> params = new HashMap<>();
		params.put(tn, "baiduimage");
		
	}
	
}
