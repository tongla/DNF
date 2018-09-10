package com.lyl.common.utils.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ByteArrayUtils {

	public static byte[] toByte(Serializable serialize) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(serialize);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return baos.toByteArray();
	}
	
	public static <T> T toObject(byte[] data, Class<T> cls) {
		return cls.cast(toObject(data));
	}
	
	public static Object toObject(byte[] data) {
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		try {
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
