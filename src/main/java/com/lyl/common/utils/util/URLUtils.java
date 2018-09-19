package com.lyl.common.utils.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.lyl.common.utils.image.ImageUtils;

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

	public static String post(String host, Map<String, Object> paramsMap) {
		HttpURLConnection conn = null;
		try {
			URL url = toURL(host);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(POST);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
			conn.setRequestProperty("Charset", "UTF-8");
			
			if (paramsMap != null && !paramsMap.isEmpty()) {
				Set<String> keys = paramsMap.keySet();
				for (String key : keys) {
					Object obj = paramsMap.get(key);
					if (obj != null)
						conn.setRequestProperty(key, paramsMap.get(key).toString());
				}
			}
			
			if (!conn.getDoOutput())
				conn.setDoOutput(true);
			
			if (!conn.getDoInput())
				conn.setDoInput(true);
			return IOUtils.readAsString(conn.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null)
				conn.disconnect();
		}
	}

	public static String get(String host, Map<String, Object> paramsMap) {
		URL url;
		if (host.contains("?"))
			url = toURL(host + appendParams(paramsMap));
		else
			url = toURL(host + "?" + appendParams(paramsMap));
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			if (!conn.getDoInput()) 
				conn.setDoInput(true);
			return IOUtils.readAsString(conn.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
		return null;
	}
	
	public static String appendParams(Map<String, Object> paramsMap) {
		if (paramsMap != null && !paramsMap.isEmpty()) {
			StringBuilder params = new StringBuilder();
			Set<String> keys = paramsMap.keySet();
			for (String key : keys) {
				params.append(key).append('=').append(paramsMap.get(key)).append('&');
			}
			return params.deleteCharAt(params.length()-1).toString();
		}
		return "";
	}
	
	public static void main(String[] args) throws IOException {
//		String imgPth = "D:/Temp/t2.jpg";
//		byte[] bytes = ImageUtils.toByteArray(ImageUtils.read(imgPth), "jpg");
//		String base64 = ImageUtils.toBase64(bytes);
//		String host = "http://localhost:5000/detection";
//		Map<String, Object> map = new HashMap<>();
//		map.put("image", base64);
//		String result = post(host, map);
//		System.out.println(result);
//		http://image.baidu.com/search/index?tn=baiduimage&ps=4&ct=201326592&lm=-1&cl=5&nc=1&ie=utf-8&word=%E7%8B%97
//     https://www.google.com/search?q=%E7%8B%97&source=lnms&tbm=isch&sa=X&ved=0ahUKEwiGi4LdrcPdAhWLro8KHUixC5AQ_AUICigB&biw=1440&bih=794
		String str = "https://www.google.com/search?";
		Map<String, Object> params = new HashMap<>();
		params.put("source", "lnms");
		params.put("tbm", "isch");
		params.put("sa", "X");
		params.put("ved", "0ahUKEwiGi4LdrcPdAhWLro8KHUixC5AQ_AUICigB");
		params.put("biw", 1440);
		params.put("bih", 794);
		params.put("q", "狗");
		
		String result = get(str, params);
		System.out.println(result);
	}

}
