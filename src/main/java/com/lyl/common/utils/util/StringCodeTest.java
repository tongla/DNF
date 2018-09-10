package com.lyl.common.utils.util;

public class StringCodeTest {
	
	public static long times(int len) {
		long time = System.currentTimeMillis();
		String str = "[{&quot;id&quot;:&quot;newId1518162977639&quot;,&quot;entityId&quot;:&quot;TMP1518162961767&quot;,&quot;startQuantity&quot;:&quot;32&quot;,&quot;endQuantity&quot;:&quot;12&quot;,&quot;unitPrice&quot;:&quot;23&quot;},{&quot;id&quot;:&quot;newId1518162974556&quot;,&quot;entityId&quot;:&quot;TMP1518162961767&quot;,&quot;startQuantity&quot;:&quot;12&quot;,&quot;endQuantity&quot;:&quot;12&quot;,&quot;unitPrice&quot;:&quot;21&quot;}]";
		for (int i = 0; i < len; i++) {
//			StringCodeUtils.oldDecode(str); 
			StringCodeUtils.decode(str);
		}
		time = System.currentTimeMillis() - time;
		return time;
	}
	
	public static void test() {
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			long t = times(20000);
			sum += t;
		}
		System.out.println(sum);
		System.out.println(sum / 10.0);
	}

	public static void main(String[] args) {
		test();
	}
}
