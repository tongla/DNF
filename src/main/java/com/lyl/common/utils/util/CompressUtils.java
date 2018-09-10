package com.lyl.common.utils.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class CompressUtils {

	public static byte[] compressGZIP(byte[] data) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		GZIPOutputStream gzos = null;
		try {
			gzos = new GZIPOutputStream(baos);
			gzos.write(data);
			gzos.finish();
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.close(gzos, baos);
		}
		return null;
	}

	public static byte[] decompressGZIP(byte[] data) {
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		GZIPInputStream gzis = null;
		try {
			gzis = new GZIPInputStream(bais);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			IOUtils.copy(gzis, baos);
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.close(gzis, bais);
		}
		return null;
	}
	
	public static byte[] compressZIP(byte[] data) {
		return compressZIP(data, "zip");
	}
	public static byte[] compressZIP(byte[] data, String fileName) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ZipOutputStream zos = new ZipOutputStream(baos);
		ZipEntry entry = new ZipEntry(fileName);
		entry.setSize(data.length);
		try {
			zos.putNextEntry(entry);
			zos.write(data);
			zos.finish();
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.close(zos, baos);
		}
		return null;
	}
	
	public static byte[] decompressZIP(byte[] data) {
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		ZipInputStream zis = new ZipInputStream(bais);
		try {
			while(zis.getNextEntry() != null) {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buf = new byte[4096];
				int len;
				while((len = zis.read(buf)) != -1) {
					baos.write(buf, 0, len);
				}
				return baos.toByteArray();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.close(zis, bais);
		}
		return null;
	}
	
}
