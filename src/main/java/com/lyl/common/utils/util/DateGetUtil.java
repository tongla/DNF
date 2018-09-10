package com.lyl.common.utils.util;

import java.util.Calendar;
import java.util.Date;

public class DateGetUtil {

	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 共享 Calendar 对象
	 */
	private static Calendar c = Calendar.getInstance();
	
	public static int get(long millis, int field) {
		synchronized (c) {
			c.setTimeInMillis(millis);
			return c.get(field);
		}
	}
	
	public static int[] get(long millis, int...fields) {
		int[] values = new int[fields.length];
		synchronized (c) {
			c.setTimeInMillis(millis);
			for (int i = 0; i < fields.length; i++) {
				if (fields[i] == Calendar.MONTH)
					values[i] = c.get(fields[i]) + 1;
				else
					values[i] = c.get(fields[i]);
			}
		}
		return values;
	}
	
	/**
	 * 将 int 数组转换成 int1-int2...形式的字符串, 并且对个位进行补零
	 * @param array
	 * @return
	 */
	public static String timeToString(int... array) {
		return timeToString('-', array).toString();
	}
	
	public static StringBuilder timeToString(char separator, int... array) {
		StringBuilder str = new StringBuilder(array.length * 2 + array.length + 2);
		for (int i = 0; i < array.length-1; i++) {
			if (array[i] < 10) 
				str.append('0');
			str.append(array[i]).append(separator);
		}
		if (array[array.length-1] < 10) 
			str.append('0');
		return str.append(array[array.length-1]);
	}

	/**
	 * 获取当前年 - yyyy
	 * 
	 * @return
	 */
	public static String getYear() {
		return getYear(System.currentTimeMillis());
	}

	/**
	 * 获取指定日期年
	 */
	public static String getYear(Date date) {
		return getYear(date.getTime());
	}

	/**
	 * 获取指定日期年
	 */
	public static String getYear(long millis) {
		return new Integer(get(millis, Calendar.YEAR)).toString();
	}
	
	/**
	 * 获取当月 - MM
	 * 
	 * @return
	 */
	public static String getMonth() {
		return getMonth(System.currentTimeMillis());
	}

	/**
	 * 获取指定日期月份 - MM
	 * 
	 * @return
	 */
	public static String getMonth(Date date) {
		return getMonth(date.getTime());
	}

	/**
	 * 获取指定日期月份 - MM
	 * 
	 * @return
	 */
	public static String getMonth(long millis) {
		return new Integer(get(millis, Calendar.MONTH) + 1).toString();
	}

	/**
	 * 获取当日 - dd
	 * 
	 * @return
	 */
	public static String getDayOfMonth() {
		return getDayOfMonth(System.currentTimeMillis());
	}

	/**
	 * 获取指定日 - dd
	 * 
	 * @return
	 */
	public static String getDayOfMonth(Date date) {
		return getDayOfMonth(date.getTime());
	}

	/**
	 * 获取指定日 - dd
	 * 
	 * @return
	 */
	public static String getDayOfMonth(long millis) {
		return new Integer(get(millis, Calendar.DAY_OF_MONTH)).toString();
	}

	/**
	 * 获取当前年月 - yyyy-MM
	 * 
	 * @return
	 */
	public static String getYearMonth() {
		return getYearMonth(System.currentTimeMillis());
	}

	/**
	 * 获取指定时间年月 - yyyy-MM
	 * 
	 * @param date
	 * @return
	 */
	public static String getYearMonth(Date date) {
		return getYear(date.getTime());
	}

	/**
	 * 获取指定时间年月 - yyyy-MM
	 * 
	 * @param millis
	 * @return
	 */
	public static String getYearMonth(long millis) {
		return timeToString(get(millis, Calendar.YEAR, Calendar.MONTH));
	}

	/**
	 * 获取当前月日 - MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String getMonthDay() {
		return getMonthDay(System.currentTimeMillis());
	}

	/**
	 * 获取指定日期月日 - MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String getMonthDay(Date date) {
		return getMonthDay(date.getTime());
	}

	/**
	 * 获取指定日期月日 - MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String getMonthDay(long currentTimeMillis) {
		return timeToString(get(currentTimeMillis, Calendar.MONTH, Calendar.DAY_OF_MONTH));
	}

	/**
	 * 获取当前年日 - yyyy-dd
	 * 
	 * @return
	 */
	public static String getYearDay() {
		return getYearDay(System.currentTimeMillis());
	}

	/**
	 * 获取指定年日 - yyyy-dd
	 * 
	 * @return
	 */
	public static String getYearDay(Date date) {
		return getYearDay(date.getTime());
	}

	/**
	 * 获取指定年日 - yyyy-dd
	 * 
	 * @return
	 */
	public static String getYearDay(long millis) {
		return timeToString(get(millis, Calendar.YEAR, Calendar.DAY_OF_MONTH));
	}

	/**
	 * 获取当前年月日 - yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getYearMonthDay() {
		return getYearMonthDay(System.currentTimeMillis());
	}

	/**
	 * 获取指定日期年月日
	 * 
	 * @param date
	 * @return
	 */
	public static String getYearMonthDay(Date date) {
		return getYearMonthDay(date.getTime());
	}
	
	/**
	 * 获取指定日期年月日
	 * 
	 * @param millis
	 * @return
	 */
	public static String getYearMonthDay(long millis) {
		return timeToString(get(millis, Calendar.YEAR, Calendar.MONDAY, Calendar.DAY_OF_MONTH));
	}
	
	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static String getTime() {
		return getTime(System.currentTimeMillis());
	}

	/**
	 * 获取指定日期格式时间 - yyyy-MM-dd HH:mm:ss
	 */
	public static String getTime(Date date) {
		return getTime(date.getTime());
	}

	/**
	 * 获取指定日期格式时间 - yyyy-MM-dd HH:mm:ss
	 */
	private static String getTime(long millis) {
		int[] time = get(millis, Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND);
		return timeToString('-', time[0], time[1], time[2]).append(' ').append(timeToString(':', time[3], time[4], time[5])).toString();
	}

	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	public static Date getDate() {
		return new Date();
	}

	public static void setDate(Date date, int field, int value) {
		synchronized (c) {
			c.setTimeInMillis(date.getTime());
			c.set(field, value);
			date.setTime(c.getTimeInMillis());
		}
	}

	public static void addDate(Date date, int field, int amount) {
		synchronized (c) {
			c.setTimeInMillis(date.getTime());
			c.add(field, amount);
			date.setTime(c.getTimeInMillis());
		}
	}

	public static void subDate(Date date, int field, int amount) {
		addDate(date, field, -amount);
	}

	public static Date getDate(String date) {
		return SimpleDateUtils.parse(date);
	}

	public static Date getDate(String date, String pattern) {
		return SimpleDateUtils.parse(date, pattern);
	}

	public static void addYear(Date date, int amount) {
		addDate(date, Calendar.YEAR, amount);
	}

	public static void addMonth(Date date, int amount) {
		addDate(date, Calendar.MONTH, amount);
	}

	public static void addDay(Date date, int amount) {
		addDate(date, Calendar.DAY_OF_MONTH, amount);
	}

	public static void addWeek(Date date, int amount) {
		addDate(date, Calendar.WEEK_OF_MONTH, amount);
	}

	public static void addHours(Date date, int amount) {
		addDate(date, Calendar.HOUR_OF_DAY, amount);
	}

	public static void addMinute(Date date, int amount) {
		addDate(date, Calendar.MINUTE, amount);
	}

	public static void addSecond(Date date, int amount) {
		addDate(date, Calendar.SECOND, amount);
	}

}
