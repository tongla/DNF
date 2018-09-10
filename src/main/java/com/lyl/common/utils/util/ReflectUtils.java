package com.lyl.common.utils.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectUtils {
	
	public static Field[] getFields(Object obj) {
		return getFields(obj.getClass());
	}
	
	public static Field[] getFields(Class<?> cls) {
		return cls.getFields();
	}
	
	public static Field[] getDeclaredFields(Object obj) {
		return getDeclaredFields(obj.getClass());
	}
	
	public static Field[] getDeclaredFields(Class<?> cls) {
		return cls.getDeclaredFields();
	}
	
	public static Method[] getDeclaredMethods(Object obj) {
		return getDeclaredMethods(obj.getClass());
	}
	
	public static Method[] getDeclaredMethods(Class<?> cls) {
		return cls.getDeclaredMethods();
	}
	
	public static Annotation[] getDeclaredAnnotations(Object obj) {
		return getDeclaredAnnotations(obj.getClass());
	}
	
	public static Annotation[] getDeclaredAnnotations(Class<?> cls) {
		return cls.getDeclaredAnnotations();
	}
	
	public static Field getDeclaredField(String fieldName, Object obj) {
		try {
			return obj.getClass().getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void set(Field field, Object obj, Object value) {
		field.setAccessible(true);
		try {
			field.set(obj, value);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public static void set(String fieldName, Object obj, Object value) {
		set(getDeclaredField(fieldName, obj), obj, value);
	}
	
	public static Object get(Field field, Object obj) {
		field.setAccessible(true);
		try {
			return field.get(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object get(String fieldName, Object obj) {
		return get(getDeclaredField(fieldName, obj), obj);
	}
	
	public static Method getDeclaredMethod(Object obj, String methodName, Class<?>...parameterTypes) {
		try {
			return obj.getClass().getDeclaredMethod(methodName, parameterTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object invoke(Method method, Object obj, Object...args) {
		method.setAccessible(true);
		try {
			return method.invoke(obj, args);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
