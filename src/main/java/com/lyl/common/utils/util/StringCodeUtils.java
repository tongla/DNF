package com.lyl.common.utils.util;

import java.io.UnsupportedEncodingException;

public class StringCodeUtils {

	public static final String ASCII = "ASCII";

	public static final String ANSI = "ANSI";

	/**
	 * 繁体
	 */
	public static final String BIG5 = "BIG5";

	/**
	 * 日本
	 */
	public static final String EUC_JP = "EUC-JP";

	public static final String GB2312 = "GB2312";

	public static final String GBK = "GBK";

	public static final String GB18030 = "GB18030";

	public static final String UTF_8 = "UTF-8";

	public static final String UTF_16 = "UTF-16";

	public static final String UTF_16BE = "UTF-16BE";

	public static final String UTF_16LE = "UTF-16LE";

	/**
	 * 欧洲
	 */
	public static final String ISO_8859_1 = "ISO-8859-1";

	/**
	 * 拉丁
	 */
	public static final String LATIN_1 = "LATIN_1";

	public static String decode(String value) {
		if (value == null)
			return null;
		value = value.replaceAll("&lt;", "<");
		value = value.replaceAll("&gt;", ">");
		value = value.replaceAll("&quot;", "\"");
		value = value.replaceAll("&#39;", "'");
		value = value.replaceAll("&#37;", "%");
		value = value.replaceAll("&#59;", ";");
		value = value.replaceAll("&#40;", "(");
		value = value.replaceAll("&#41;", ")");
		value = value.replaceAll("&amp;", "&");
		value = value.replaceAll("&#43;", "+");
		return value;
	}

	public static String encode(String value) {
		if (value == null) 
			return null;
		value = value.replaceAll("<", "&lt;");
		value = value.replaceAll(">", "&gt;");
		value = value.replaceAll("\"", "&quot;");
		value = value.replaceAll("'", "&#39;");
		value = value.replaceAll("%", "&#37;");
		value = value.replaceAll("\\(", "&#40;");
		value = value.replaceAll("\\)", "&#41;");
		value = value.replaceAll("\\+", "&#43;");
		return value;
	}

	public static String encode(byte[] buf, String encoding) {
		if (buf == null)
			return null;
		try {
			return new String(buf, encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String toUTF8(String content, String code) {
		try {
			return encode(content.getBytes(code), StringCodeUtils.UTF_8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String to(String content, String fromCode, String toCode) {
		try {
			return new String(content.getBytes(fromCode), toCode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
