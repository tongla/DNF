package com.baidu.aip.image;

import java.awt.image.BufferedImage;
import java.util.HashMap;


import org.json.JSONObject;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.lyl.common.utils.GsonUtils;
import com.lyl.common.utils.image.ImageUtils;

public class AipImageUtils {

	private static AipImageClassify aipImage;
	
	static {
		aipImage = new AipImageClassify(AuthImage.APP_ID, AuthImage.APP_KEY, AuthImage.SECRET_KEY);
	}
	
	public static JSONObject advancedGeneral(byte[] image, HashMap<String, String> options) {
		return aipImage.advancedGeneral(image, options);
	}
	
	public static JSONObject objectDetect(final String image, final HashMap<String, String> options) {
		return aipImage.objectDetect(image, options);
	}
	
	public static void main(String[] args) {
		String path = "D:\\tmp\\t2.jpg";
		JSONObject json = objectDetect(path, null);
		System.out.println(json);
		
		ImageResult result = GsonUtils.jsonToObject(json.toString(), ImageResult.class);
		
		BufferedImage image = ImageUtils.read(path);
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		for (int i = result.getResult().getLeft(); i < result.getResult().getWidth(); i++) {
			for (int j = result.getResult().getTop(); j < result.getResult().getHeight(); j++) {
				int rgb = image.getRGB(i, j);
//				int R =(rgb & 0xff0000 ) >> 16 ;
//				int G = (rgb & 0xff00 ) >> 8 ;
//				int B = (rgb & 0xff );
				newImage.setRGB(i, j, rgb);
			}
		}
		newImage.flush();
		path = "D:/t.JPG";
		ImageUtils.write(newImage, path);
		
	}
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
