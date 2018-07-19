package com.lyl.common.util;

import java.net.MalformedURLException;
import java.net.URL;

public class URLUtils {

	public static URL toURL(String host) {
		try {
			return new URL(host);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
