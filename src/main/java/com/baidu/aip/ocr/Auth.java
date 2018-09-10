package com.baidu.aip.ocr;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.json.JSONObject;

import com.lyl.common.utils.util.UrlUtils;

public class Auth {
	
	private static String authHost = "https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id=$&client_secret=$";
	
	private static Map<String, String> accessTokenMap = new HashMap<>();
	
	static {
		Properties p = new Properties();
		try {
			p.load(Auth.class.getClassLoader().getResourceAsStream("auth.properties"));
			System.out.println(p.getProperty("OCR_APP_ID"));
			accessTokenMap.put(p.getProperty("OCR_APP_ID"), getAuth(p.getProperty("OCR_APP_KEY"), p.getProperty("OCR_SECRET_KEY")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getAuth(String appKey, String secretKey) {
		 return new JSONObject(UrlUtils.readAsString(authHost.replaceFirst("$", appKey).replaceFirst("$", secretKey))).getString("access_token");
	}
	
//	public static String getAccessToken(String appId) {
//		String accessToken = accessTokenMap.get(appId);
//		if (accessToken != null)
//			return accessToken;
//	}
	
	public static void main(String[] args) {
		System.out.println(accessTokenMap);
	}
	
}
