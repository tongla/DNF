package com.lyl.common.utils.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectArrayUtils {
	
	public static byte[] toByteArray(Serializable obj) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.close(baos);
			IOUtils.close(oos);
		}
		return null;
	}
	
	public static Object toObject(byte[] data) {
		if (data == null)
			return null;
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			IOUtils.close(bais);
			IOUtils.close(ois);
		}
		return null;
	}
	
	public static <T> T toObject(byte[] data, Class<T> cls) {
		Object obj = toObject(data);
		if (cls != null) 
			return cls.cast(obj);
		return null;
	}
	
}
