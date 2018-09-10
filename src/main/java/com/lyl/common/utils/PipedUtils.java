package com.lyl.common.utils;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedUtils {

	public static void write(PipedOutputStream output, byte[] buf) {
		try {
			output.write(buf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int read(PipedInputStream input, byte[] buf) {
		try {
			return input.read(buf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}
