package com.lyl.common.utils.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonHelper {

	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	private static GsonBuilder gsonBuilder = initGsonBuilder(DEFAULT_DATE_FORMAT);
	
	private static Gson gson = gsonBuilder.create();
	
	private static GsonBuilder initGsonBuilder(String dateFormat) {
		return new GsonBuilder().setDateFormat(dateFormat).enableComplexMapKeySerialization();
	}
	
	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}
	
	public static Object toObject(String json, Class<?> cls) {
		return gson.fromJson(json, cls);
	}
	
	public static void registerTypeAdapter(RegisterTypeAdapter...registerTypeAdapters) {
		if (registerTypeAdapters != null) {
			for (RegisterTypeAdapter registerTypeAdapter : registerTypeAdapters) {
				gsonBuilder.registerTypeAdapter(registerTypeAdapter.getType(), registerTypeAdapter.getTypeAdapter());
			}
			gson = gsonBuilder.create();
		}
	}
	
	public static class RegisterTypeAdapter {
		
		private Type type;
		
		private Object typeAdapter;
		
		public RegisterTypeAdapter(Type type, Object typeAdapter) {
			this.type = type;
			this.typeAdapter = typeAdapter;
		}

		public Type getType() {
			return type;
		}

		public void setType(Type type) {
			this.type = type;
		}

		public Object getTypeAdapter() {
			return typeAdapter;
		}

		public void setTypeAdapter(Object typeAdapter) {
			this.typeAdapter = typeAdapter;
		}
		
	}
	
}
