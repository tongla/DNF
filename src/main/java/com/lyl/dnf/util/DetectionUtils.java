package com.lyl.dnf.util;

import java.awt.image.BufferedImage;

import com.lyl.dnf.entity.Detection;

public class DetectionUtils {

	public static Detection detection(byte[] bytes, double scores) {
		return new Detection();
	}
	
	public static Detection detection(BufferedImage image, double scores) {
		return new Detection();
	}
	
	public static Detection detection(String base64, double scores) {
		return new Detection();
	}
	
}
