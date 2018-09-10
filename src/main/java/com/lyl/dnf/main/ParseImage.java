package com.lyl.dnf.main;

import java.awt.image.BufferedImage;

import com.baidu.aip.entity.Location;

public interface ParseImage {
	
	// 返回解析的全部结果
	String parseImage(String text, BufferedImage image);
	
	String parseImage(String text, byte[] image);

	// 解析图片，返回文字在目标图片中的位置, 可模糊匹配
	Location getLocation(String text, BufferedImage image);
	
	Location getLocation(String text, byte[] image);
	
}
