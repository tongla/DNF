package com.lyl.common.utils.letter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrangeLetter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("input:");
		String line = input.nextLine();
		System.out.println(arrange(line));
		input.close();
	}
	
	public static List<String> arrange(String str) {
		if (str != null && str.trim().length() > 0) {
			char[] chs = str.toCharArray();
			List<String> strs = new ArrayList<>();
			StringBuilder tmp = new StringBuilder();
			
			
		}
		return null;
	}
}
