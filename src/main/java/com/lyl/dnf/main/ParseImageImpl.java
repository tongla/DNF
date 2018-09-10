package com.lyl.dnf.main;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;

import com.baidu.aip.entity.Location;
import com.baidu.aip.ocr.AipOcrUtils;
import com.baidu.aip.ocr.OcrResult;
import com.baidu.aip.ocr.OcrResult.WordResult;
import com.lyl.common.utils.GsonUtils;
import com.lyl.common.utils.image.ImageUtils;
import com.lyl.dnf.util.TypeRobot;

public class ParseImageImpl implements ParseImage {
	
	public OcrResult parseImage(TypeRobot robot) {
		return parseImage(robot.printScreen(), null);
	}

	public OcrResult parseImage(BufferedImage image, HashMap<String, String> options) {
		byte[] bytes = ImageUtils.toByteArray(image, "png");
		String json = AipOcrUtils.general(bytes, options).toString();
		return GsonUtils.jsonToObject(json, OcrResult.class);
	}

	@Override
	public String parseImage(String text, BufferedImage image) {
		return null;
	}

	@Override
	public String parseImage(String text, byte[] image) {
		return null;
	}

	@Override
	public Location getLocation(String text, BufferedImage image) {
		if (text == null || image == null) {
			return null;
		}
		OcrResult o = parseImage(image, null);
		List<WordResult> wordList = o.getWords_result();
		if (wordList != null) {
			int maxIndex = 0;
			int maxRight = 0;
			for (int i = 0; i < o.getWords_result().size(); i++) {
				WordResult result = o.getWords_result().get(i);
				String words = result.getWords();
				if (words != null) {
					int len;
					if (text.length() > words.length()) {
						len = text.length();
					} else {
						len = words.length();
					}
					int right = 0;
					for (int j = 0; j < len; j++) {
						if (text.charAt(j) == words.charAt(j)) {
							right++;
						}
					}
					if (maxRight < right) {
						maxRight = right;
						maxIndex = i;
					}
				}
			}
			return wordList.get(maxIndex).getLocation();
		}
		return null;
	}

	@Override
	public Location getLocation(String text, byte[] image) {
		return null;
	}
	
	
	
}
