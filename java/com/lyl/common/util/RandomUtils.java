package com.lyl.common.util;

import java.util.Random;

public class RandomUtils {

	private static Random ran = new Random();
	
	public static String randomString(int count, String chs) {
		return randomString(count, chs.toCharArray());
	}
	
	public static String randomString(int count, char[] chs) {
		char[] ch = randomChars(count, chs);
		return new String(ch);
	}
	
	public static char[] randomChars(int count, String chs) {
		return randomChars(count, chs.toCharArray());
	}
	
	public static synchronized char[] randomChars(int count, char[] chs) {
		if (count < 1 || chs == null || chs.length < 1)
			return null;
		char[] ch = new char[count];
		for (int i = 0; i < count; i++) {
			ch[i] = chs[ran.nextInt(chs.length)];
		}
		return ch;
	}
	
	public static char randomLetter() {
		return ran.nextBoolean() ? randomLetterLower() : randomLetterUpper();
	}
	
	public static char randomNumber() {
		return (char)(ran.nextInt(10) + 48);
	}
	
	public static char randomLetterLower() {
		return (char)(ran.nextInt(26) + 97);
	}
	
	public static char randomLetterUpper() {
		return (char)(ran.nextInt(26) + 65);
	}
	
	public static int randomInt() {
		return ran.nextInt();
	}
	
	public static int randomInt(int bound) {
		return ran.nextInt(bound);
	}
	
	public static long randomLong() {
		return ran.nextLong();
	}
	
}
