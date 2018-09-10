package com.lyl.common.utils;

import com.lyl.common.utils.util.RandomUtils;

public class ArrayUtils {
	
	public static int[] initArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = i;
		}
		return array;
	}
	
	public static void shuffle(int[] arr) {
		for (int i = 0, r, t; i < arr.length; i++) {
			r = RandomUtils.randomInt(arr.length - i);
			t = arr[r];
			arr[r] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = t;
		}
	}

	public static int[] randomNoReArray(int size) {
		int[] arr = initArray(size);
		shuffle(arr);
		return arr;
	}
	
	public static int[] randomNoReArray2(int size) {
		int[] seed = initArray(size);
		
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			int r = RandomUtils.randomInt(size - 1 - i);
			array[i] = seed[r];
			seed[r] = seed[size - 1 - i];
		}
		return array;
	}
	
	public static int[] randomNoReArray(int size, int bound) {
		if (size > bound) {
			throw new IllegalArgumentException("随机数范围比数组范围要小!");
		}
		int[] seed = initArray(bound);
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			int r = RandomUtils.randomInt(bound - i);
			arr[i] = seed[r];
			seed[r] = seed[bound - 1 - i];
			seed[bound -1 - i] = arr[i];
		}
		return arr;
	}
	
	public static int[] randomArray(int size, int bound) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = RandomUtils.randomInt(bound);
		}
		return arr;
	}
	
	public static int[] slice(int[] array) {
		if (array != null && array.length > 47) {
			int len = array.length / 2;
			int[] left = new int[len];
			System.arraycopy(array, 0, left, 0, len);
			int[] right = new int[array.length-len];
			System.arraycopy(array, len, right, 0, right.length);
			
			slice(left);
			slice(right);
		}
		return array;
	}
	
	public static void main(String[] args) {
		long t = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			int[] ran = randomNoReArray(1000000);
		}
		t = System.currentTimeMillis() - t;
		System.out.println(t);
	}
	
}
