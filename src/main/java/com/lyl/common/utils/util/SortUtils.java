package com.lyl.common.utils.util;

import java.util.Arrays;

public class SortUtils {

	
	public static void quickSort(int[] arr) {
		
	}
	
	public static void mySort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int t = i;
			
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[t]) {
					t = j;
				}
			}
		
			if (t != i) {
				int tmp = arr[t];
				arr[t] = arr[i];
				arr[i] = tmp;
			}
			
		}
	}
	
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr.length - 1 - i;
		}
		
		long t = System.currentTimeMillis();
//		mySort(arr);
//		bubbleSort(arr);
//		Arrays.sort(arr);
		t = System.currentTimeMillis() - t;
		System.out.println(t);
		System.out.println(Arrays.toString(arr));
				
	}
}
