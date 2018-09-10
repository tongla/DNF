package com.lyl.common.utils;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonUtils {
	
	private GsonUtils() {}
	
	/**
	 * 默认日期转换格式
	 */
	private static final String DEFAULT_DATE_FORMAT;
	
	private static GsonBuilder gb;
	
	private static Gson gson ;
	
	private static Map<String, Gson> customGsons;
	
	private static int maxSize;
	
	static {
		DEFAULT_DATE_FORMAT = new String("yyyy-MM-dd HH:mm:ss"); 
		gb = createGsonBuilder(DEFAULT_DATE_FORMAT); // 
		gson = gb.create();
		customGsons = new HashMap<String, Gson>();
		maxSize = 16;
	}
	public static String objectToJson(Object obj) {
		return gson.toJson(obj);
	}
	
	public static String objectToJson4Null(Object obj) {
		if (customGsons.containsKey("gsonNull")) 
			return customGsons.get("gsonNull").toJson(obj);
		clearGsonMap();
		Gson gson = createGsonBuilder(DEFAULT_DATE_FORMAT).serializeNulls().create();
		customGsons.put("gsonNull", gson);
		return gson.toJson(obj);
	}
	
	public static String objectToJson(Object obj, String dateFormat) {
		return getFormatGson(dateFormat).toJson(obj);
	}
	
	public static String objectToJson4Null(Object obj, String dateFormat) {
		String key = "gsonNull" + dateFormat;
		if (customGsons.containsKey(key)) 
			return customGsons.get(key).toJson(obj);
		clearGsonMap();
		Gson gson = createGsonBuilder(dateFormat).serializeNulls().create();
		customGsons.put(key, gson).toJson(obj);
		return gson.toJson(obj);
	}
	
	public static <T> T jsonToObject(String json, Class<T> c) {
		return gson.fromJson(json, c);
	}
	
	public static <T> T jsonToObject(String json, Type type) {
		return gson.fromJson(json, type);
	}
	
	public static <T> T jsonToObject(String json, Class<T> c, String dateFormat) {
		return getFormatGson(dateFormat).fromJson(json, c);
	}
	
	public static <T> T jsonToObject(String json, Type type, String dateFormat) {
		return getFormatGson(dateFormat).fromJson(json, type);
	}
	
	public static JsonElement objectToJsonTree(Object src) {
		return gson.toJsonTree(src);
	}
	
	public static JsonElement objectToJsonTree(Object src, Type typeOfSrc) {
		return gson.toJsonTree(src, typeOfSrc);
	}
	
	public static <T> T jsonToObject(JsonElement ele, Class<T> classOfT) {
		return gson.fromJson(ele, classOfT);
	}
	
	public static <T> T jsonToObject(JsonElement json, Type typeOfT) {
		return gson.fromJson(json, typeOfT);
	}
	
	public static void setMaxSize(int maxSize) {
		GsonUtils.maxSize = Math.abs(maxSize);
	}
	
	public static GsonBuilder resetGsonBuilder() {
		gb = createGsonBuilder(DEFAULT_DATE_FORMAT);
		gson = gb.create();
		return gb;
	}
	
	private static Gson getFormatGson(String dateFormat) {
		if (customGsons.containsKey(dateFormat)) 
			return customGsons.get(dateFormat);
		clearGsonMap();
		Gson gson = gb.setDateFormat(dateFormat).create();
		customGsons.put(dateFormat, gson);
		return gson;
	}
	
	private static void clearGsonMap() {
		synchronized (customGsons) {
			if (customGsons.size() > maxSize)
				customGsons.clear();
		}
	}
	
	private static GsonBuilder createGsonBuilder(String defaultDateFormat) {
		return createDefaultTypeAdapter(new GsonBuilder()).enableComplexMapKeySerialization().setDateFormat(defaultDateFormat);
	}
	
	private static GsonBuilder createDefaultTypeAdapter(GsonBuilder gs) {
//		gs.registerTypeAdapter((Type) HibernateProxy.class , new HibernateProxyTypeAdapter(gson));
		gs.registerTypeHierarchyAdapter(Date.class, new DateTypeAdatper(DEFAULT_DATE_FORMAT));
		return gs;
	}
	
	public static class RegisterTypeAdapter {
		
		private Type clazz;
		
		private Object typeAdapter;

		public RegisterTypeAdapter(Type clazz, Object typeAdapter) {
			this.clazz = clazz;
			this.typeAdapter = typeAdapter;
		}

		public Type getClazz() {
			return clazz;
		}

		public void setClazz(Class<?> clazz) {
			this.clazz = clazz;
		}

		public Object getTypeAdapter() {
			return typeAdapter;
		}

		public void setTypeAdapter(Object typeAdapter) {
			this.typeAdapter = typeAdapter;
		}
		
	}
	
	public static class DateTypeAdatper implements JsonSerializer<Date>, JsonDeserializer<Date> {
		
		private String dateFormat;
		
		public DateTypeAdatper(String dateFormat) {
			this.dateFormat = dateFormat;
		}
		
		@Override
		public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			String date = json.getAsJsonPrimitive().getAsString();
			if ("".equals(date))
				return null;
			Date td = null;
			if (date.length() != dateFormat.length()) {
				td = parse(DateFormat.getDateInstance(), date);
			}
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			if (td != null) {
				date = sdf.format(td);
			}
			return parse(sdf, date);
		}
		
		public Date parse(DateFormat df, String date) {
			try {
				return df.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
			return new JsonPrimitive(new SimpleDateFormat(dateFormat).format(src));
		}
		
	}
	
	public static void registerTypeAdapters(RegisterTypeAdapter...adapters) {
		for (RegisterTypeAdapter adapter : adapters) {
			gb.registerTypeAdapter(adapter.clazz, adapter.typeAdapter);
		}
		gson = gb.create();
	}
	
	public static synchronized GsonBuilder getGsonBuilder() {
		return gb;
	}
	
}
