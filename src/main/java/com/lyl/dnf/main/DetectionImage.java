package com.lyl.dnf.main;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public interface DetectionImage {
	
	String parseImage(String text, BufferedImage image);
	
	String parseImage(String text, byte[] image);

	Rectangle getLocation(String text, BufferedImage image);
	
	Rectangle getLocation(String text, byte[] image);
	
}
