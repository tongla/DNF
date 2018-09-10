package com.lyl.common.utils.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class IOUtils {
	
	public static String readAsString(InputStream input) {
		return readAsString(input, 4096);
	}
	
	public static String readAsString(InputStream input, int bufSize) {
		StringBuilder content = null;
		try {
			content = new StringBuilder(input.available());
			byte[] buf = new byte[bufSize];
			int len;
			while((len = input.read(buf)) != -1) {
				content.append(new String(buf, 0, len));
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return content.toString();
	}
	
	public static byte[] readAsByteArray(InputStream input) {
		try {
			byte[] bytes = new byte[input.available()];
			input.read(bytes);
			return bytes;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取数据失败:" + e.getMessage());
		}
	}	
	
	public static void copy(InputStream input, OutputStream output) throws IOException {
		byte[] tmp = new byte[4096];
		int len;
		while((len = input.read(tmp)) != -1) {
			output.write(tmp, 0, len);
		}
	}
	
	public static void close(InputStream... inputs) {
		if (inputs != null) {
			for (InputStream input : inputs) {
				if (input != null) {
					try {
							input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void close(OutputStream... outputs) {
		if (outputs != null) {
			for (OutputStream output : outputs) {
				if (output!= null) {
					try {
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static void close(Reader...readers) {
		if (readers != null) {
			for (Reader reader : readers) {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static void close(Writer...writers) {
		if (writers != null) {
			for (Writer writer : writers) {
				if (writer != null) {
					try {
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
}
