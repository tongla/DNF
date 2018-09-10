package com.lyl.common.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.lyl.common.utils.util.RandomUtils;


public class Encryption {
	
//	private static final char[] DOT = new char[] {'0','1','2','3','4'};
	private static final char[] DOT = new char[] {'0','1','2','3','4', 'a','b','c','d','e'};
	
//	private static final char[] LINE = new char[] {'5', '6', '7', '8', '9'};
	private static final char[] LINE = new char[] {'5', '6', '7', '8', '9', 'j', 'f', 'g','h','i'};
	
	private static Map<Character, Character> decrypt = new HashMap<Character, Character>();
	
	private static Map<String, String> codeTable = new HashMap<String, String>();
	
	static {
		for (char ch : DOT) {
			decrypt.put(ch, '.');
		}
		for (char ch : LINE) {
			decrypt.put(ch, '-');
		}
		
		codeTable.put("A", ".-");
		codeTable.put("B", "-...");
		codeTable.put("C", "-.-.");
		
		Set<String> keys = codeTable.keySet();
		Map<String, String> codes = new HashMap<String, String>();
		for (String key : keys) {
			codes.put(codeTable.get(key), key);
		}
		codeTable.putAll(codes);
	}

	public static String encryption(String content) {
		if (content != null) {
			int length = content.length();
			StringBuilder password = new StringBuilder(length * 5);
			for (int i = 0; i < length; i++) {
				char ch = content.charAt(i);
				String code = codeTable.get(String.valueOf(ch));
				
				if (code != null) {
					for (int j = 0; j < code.length(); j++) {
						char c = code.charAt(j);
						if (c == '.') {
							password.append(DOT[RandomUtils.randomInt(DOT.length)]);
						} else {
							password.append(LINE[RandomUtils.randomInt(LINE.length)]);
						}
					}
				} else {
					password.append(ch);
				}
				password.append('_');
			}
			return password.toString();
		}
		return null;
	}
	
	public static String decryption(String encryption) {
		if (encryption != null) {
			String[] array = encryption.split("_");
			StringBuilder content = new StringBuilder();
			StringBuilder tmp = new StringBuilder();
			for (String letter : array) {
				tmp.setLength(letter.length());
				for (int i = 0; i < letter.length(); i++) {
					char ch = letter.charAt(i);
					Character m = decrypt.get(ch);
					if (m != null)
						tmp.append(m);
				}
				String con = codeTable.get(tmp.toString().trim());
				if (con != null) {
					content.append(con);
				} else {
					content.append(letter);
				}
				tmp.delete(0, tmp.length());
			}
			return content.toString();
		}
		return null;
	}
	
	public static void main(String[] args) {
		// ej bi 4j di cg 27 c5 b7 ah bj 1j b7 1i 18 3f 
		String code = "ej bi 4j di cg 27 c5 b7 ah bj 1j b7 1i 18 3f";
		// 0 1 2 3 4 a b c d e
		// f g h i j 5 6 7 8 9
		 
		
		String str= "AAAABBBBCCCC";
		System.out.println(str);
		str = encryption(str);
		System.out.println(str);
		
		str = decryption(str);
		System.out.println(str);
		str = decryption("6402_83c2_geb0_8eb4_fddd_46_45_09_bi_");
		System.out.println(str);
	}
	
}
