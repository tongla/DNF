package com.lyl.common.utils.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

public class URLUtils {
	
	public static final String GET = "GET";
	
	public static final String POST = "POST";
	
	public static URL toURL(String url) {
		try {
			return new URL(url);
		} catch (MalformedURLException e) {
			throw new RuntimeException(url + "转换成url失败:" + e.getMessage());
		}
	}
	
	public static String request(String spec, String method, Map<String, Object> properties) {
		try {
			if (GET.equals(method)) {
				if (properties != null && !properties.isEmpty()) {
					StringBuilder params = new StringBuilder();
					if (!spec.contains("?"))
						params.append('?');
					Set<String> keys = properties.keySet();
					for (String key : keys) {
						params.append(key).append('=').append(properties.get(key)).append('&');
					}
					spec += params.deleteCharAt(params.length()-1);
				}
			}
			URL url = toURL(spec);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if (method != null)
				conn.setRequestMethod(method);
			else
				conn.setRequestMethod(GET);
			if (!conn.getDoInput())
				conn.setDoInput(true);
			return IOUtils.readAsString(conn.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void setRequestProperty(HttpURLConnection conn, Map<String, String> propertyMap) {
		Set<String> keys = propertyMap.keySet();
		for (String key : keys) {
			conn.setRequestProperty(key, propertyMap.get(key));
		}
	}
	
}
