package com.lyl.common.utils.json;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.lyl.common.utils.json.entity.PartinerContract;


public class JsonHelper {

	private static final String GET = new String("get");
	
	private static final String SET = new String("set");
	
	public static void get(Object obj) throws Exception {
		if (obj != null) {
			Class<?> c = obj.getClass();
			Field[] fields = c.getDeclaredFields();
			for (Field field : fields) {
				System.out.println(field.getName());
				int mod = field.getModifiers();
				System.out.println(mod);
				System.out.println("isAbstract:"+Modifier.isAbstract(mod));
				System.out.println("isFinal:"+Modifier.isFinal(mod));
				System.out.println("isInterface:"+Modifier.isInterface(mod));
				System.out.println("isInterface:"+Modifier.isInterface(mod));
				System.out.println("isInterface:"+Modifier.isInterface(mod));
				System.out.println("isInterface:"+Modifier.isInterface(mod));
				System.out.println("isPublic:"+Modifier.isPublic(mod));
				System.out.println("isStatic:"+Modifier.isStatic(mod));
				System.out.println("isStrict:"+Modifier.isStrict(mod));
				System.out.println("isSynchronized:"+Modifier.isSynchronized(mod));
				System.out.println("isTransient:"+Modifier.isTransient(mod));
				System.out.println("isVolatile:"+Modifier.isVolatile(mod));
				System.out.println("---");
			}
			
			
		}
	}
	
	
	public static String objectToJson(Object obj) {
		if (obj == null)
			return null;
		
		return null;
	}
	
}
