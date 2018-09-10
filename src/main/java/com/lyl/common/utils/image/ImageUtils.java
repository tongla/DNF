package com.lyl.common.utils.image;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Base64;

import javax.imageio.ImageIO;

import com.lyl.common.utils.util.CompressUtils;


public class ImageUtils {

	public static BufferedImage read(String path) {
		return read(new File(path));
	}

	public static BufferedImage read(File file) {
		try {
			return ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static BufferedImage read(URL url) {
		try {
			return ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static BufferedImage read(InputStream input) {
		try {
			return ImageIO.read(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public static void write(RenderedImage im, String output) {
		write(im, getFormatName(output), output);
	}

	public static void write(RenderedImage im, String formatName, String output) {
		write(im, formatName, new File(output));
	}

	public static void write(RenderedImage image, String formatName, File file) {
		try {
			ImageIO.write(image, formatName, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void write(RenderedImage image, String formatName, OutputStream output) {
		try {
			ImageIO.write(image, formatName, output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static byte[] toByteArray(RenderedImage im, String formatName) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		write(im, formatName, baos);
		return baos.toByteArray();
	}

	public static byte[] toByteArray(String base64) {
		return Base64.getDecoder().decode(base64);
	}

	public static byte[] toByteArray(File filePath) {
		return toByteArray(read(filePath), getFormatName(filePath.getName()));
	}

	public static byte[] toByteArray(URL url) {
		return toByteArray(read(url), getFormatName(url.getPath()));
	}

	public static String toBase64(byte[] data) {
		return new String(Base64.getEncoder().encode(data));
	}

	public static String toBase64(BufferedImage image, String formatName) {
		return toBase64((toByteArray(image, formatName)));
	}

	public static BufferedImage toImage(byte[] data) {
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		try {
			return ImageIO.read(bais);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static BufferedImage toImage(String base64) {
		return toImage(toByteArray(base64));
	}

	public static String getFormatName(String path) {
		int lastIndexOf = path.lastIndexOf('.');
		if (lastIndexOf > -1)
			return path.substring(lastIndexOf + 1);
		return path;
	}

}
