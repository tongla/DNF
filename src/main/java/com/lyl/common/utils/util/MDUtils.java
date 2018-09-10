package com.lyl.common.utils.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MDUtils {
	
	public static String encode(byte[] data) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			md.update(data);
			return toHexString(md.digest());
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
	
	public static String stringToSHA1(String str) {
		try {
			byte[] strTmp = str.getBytes();
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(strTmp);
			return toHexString(md.digest());
		} catch (Exception e) {
			return null;
		}
	}

	public static String stringToMD5(String str) {

		try {
			byte[] strTemp = str.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			return toHexString(mdTemp.digest());
		} catch (Exception e) {
			return null;
		}
	}

	public static String fileNameToMD5(String fileName) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(fileName);
			return streamToMD5(inputStream);
		} catch (Exception e) {
			return null;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String streamToMD5(InputStream inputStream) {
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			byte[] buffer = new byte[1024];
			int numRead = 0;
			while ((numRead = inputStream.read(buffer)) > 0) {
				mdTemp.update(buffer, 0, numRead);
			}
			return toHexString(mdTemp.digest());
		} catch (Exception e) {
			return null;
		}
	}

	private static String toHexString(byte[] md) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		int j = md.length;
		char str[] = new char[j * 2];
		for (int i = 0; i < j; i++) {
			byte byte0 = md[i];
			str[2 * i] = hexDigits[byte0 >>> 4 & 0xf];
			str[i * 2 + 1] = hexDigits[byte0 & 0xf];
		}
		return new String(str);
	}
}