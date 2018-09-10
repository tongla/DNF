package com.lyl.common.utils.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

public class UrlUtils {
	
	public static final String GET = "GET";
	
	public static final String POST = "POST";
	
	public static URL toURL(String url) {
		try {
			return new URL(url);
		} catch (MalformedURLException e) {
			throw new RuntimeException(url + "转换成url失败:" + e.getMessage());
		}
	}

	public static byte[] readAsByteArray(String url) {
		return readAsByteArray(toURL(url));
	}
	
	public static byte[] readAsByteArray(URL url) {
		InputStream input = null;
		try {
			return IOUtils.toByteArray(input);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("从" + url + "读取内容失败 :" + e.getMessage());
		} finally {
			IOUtils.close(input);
		}
	}
	
	public static byte[] readAsByteArray(InputStream input) {
		try {
			byte[] bytes = new byte[input.available()];
			input.read(bytes);
			return bytes;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取数据失败:" + e.getMessage());
		}
	}
	
	public static String readAsString(String url) {
		return readAsString(toURL(url));
	}
	
	public static String readAsString(String url, String requestMethod) {
		return readAsString(toURL(url), requestMethod, null);
	}
	public static String readAsString(String url, String requestMethod, Map<String, String> headerMap) {
		return readAsString(toURL(url), requestMethod, headerMap);
	}
	
	public static String readAsString(URL url) {
		return readAsString(url, GET, null);
	}
	
	public static String readAsString(URL url, String requestMethod, Map<String, String> headerMap) {
		BufferedReader br = null;
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(requestMethod);
			if (headerMap != null) {
				Set<String> keys = headerMap.keySet();
				for (String key : keys) {
					conn.setRequestProperty(key, headerMap.get(key));
				}
			}
			conn.connect();
			return readAsString(conn.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("从" + url + "读取内容失败 :" + e.getMessage());
		} finally {
			IOUtils.close(br);
		}
	}
	
	public static String readAsString(InputStream input) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(input));
			StringBuilder result = new StringBuilder(input.available());
			String line;
			while((line = br.readLine()) != null) {
				result.append(line).append("\r\n");
			}
			return result.toString();
		} catch (IOException e) {
			throw new RuntimeException("读取数据失败!" + e.getMessage());
		}
	}
	
	public static String readAsString(String url, String args, String requestMethod, Map<String,String> propertyMap) {
		return readAsString(toURL(url), args, requestMethod, propertyMap);
	}
	
	public static String readAsString(URL url, String args, String requestMethod, Map<String,String> propertyMap) {
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(requestMethod);
			setRequestProperty(conn, propertyMap);
			conn.setDoOutput(true);
			conn.getOutputStream().write(args.getBytes("UTF-8"));
			conn.connect();
			return readAsString(conn.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("往" + url + "写入参数失败!" + e.getMessage());
		}
	}
	
	public static void setRequestProperty(HttpURLConnection conn, Map<String, String> propertyMap) {
		Set<String> keys = propertyMap.keySet();
		for (String key : keys) {
			conn.setRequestProperty(key, propertyMap.get(key));
		}
	}
	
}
