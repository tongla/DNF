package com.lyl.common.utils.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 简单日期工具
 */
public class SimpleDateUtils {

	/**
	 * 存放SimpleDateFormat的map集合
	 */
	private static Map<String, SimpleDateFormat> formatMap = new HashMap<>();
	
	/**
	 * map能存放SimpleDateFormat的最大值
	 */
	private static int maxSize = 16;
	
	/**
	 * 默认解析格式
	 */
	public static String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	
	public static String format(Date date) {
		return format(getDateFormat(DEFAULT_PATTERN), date);
	}
	
	public static String format(Date date, String pattern) {
		return format(getDateFormat(pattern), date);
	}
	
	public static Date parse(String strDate) {
		return parse(getDateFormat(DEFAULT_PATTERN), strDate);
	}
	
	public static Date parse(String strDate, String pattern) {
		return parse(getDateFormat(pattern), strDate);
	}
	
	/**
	 * 同步格式化与解析方法
	 * @param dateFormat	
	 * @param date
	 * @return
	 */
	private static String format(DateFormat dateFormat, Date date) {
		synchronized (dateFormat) {
			return dateFormat.format(date);
		}
	}
	
	private static Date parse(DateFormat dateFormat, String strDate) {
		try {
			synchronized (dateFormat) {
				return dateFormat.parse(strDate);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 设定 map 最多能存放多少个SimpleDateFormat对象
	 * @param size
	 */
	public static void setMaxSize(int size) {
		maxSize = Math.abs(size);
	}
	
	/**
	 * 当 map 的容量达到设定的最大值时，清除 map 里所有的 SimpleDateFormat 对象
	 */
	public static void clearFormatMap() {
		synchronized (formatMap) {
			if (formatMap.size() > maxSize)
				formatMap.clear();
		}
	}
	
	/**
	 * 根据日期格式从map里获取SimpleDateFormat对象，如果不存在则根据日期格式创建一个SimpleDateFormat对象，存入map之后返回该对象
	 * @param pattern
	 * @return
	 */
	private static SimpleDateFormat getDateFormat(String pattern) {
		SimpleDateFormat format = formatMap.get(pattern);
		if (format != null)
			return format;
		clearFormatMap();
		format = new SimpleDateFormat(pattern);
		formatMap.put(pattern, format);
		return format;
	}
	
}
