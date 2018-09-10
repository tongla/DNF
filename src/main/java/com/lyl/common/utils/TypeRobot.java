package com.lyl.common.utils;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.baidu.aip.ocr.AipOcrUtils;
import com.baidu.aip.ocr.OcrResult;
import com.lyl.common.utils.image.ImageUtils;
import com.lyl.common.utils.util.RandomUtils;

public class TypeRobot {
	
	private Robot robot;
	
	public TypeRobot() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void keyTyped(int...keycodes) {
		for (int keycode : keycodes) {
			robot.keyPress(keycode);
			robot.keyRelease(keycode);
		}
	}
	
	public void keyDownRelease(int...keycodes) {
		for (int keycode : keycodes) {
			robot.keyPress(keycode);
		}
		for (int keycode : keycodes) {
			robot.keyRelease(keycode);
		}
	}
	
	public BufferedImage printScreen() {
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		return robot.createScreenCapture(screenRect);
	}
	
	public OcrResult discern(BufferedImage image) {
		return GsonUtils.jsonToObject(AipOcrUtils.general(ImageUtils.toByteArray(image, "png"), null).toString(), OcrResult.class);
	}
	
	public int[] comKey(int size) {
		int[] code = new int[size];
		for (int i = 0; i < size; i++) {
			code[i] = RandomUtils.randomLetterUpper();
			if (code[i] == 'V' || code[i] == 'U' || code[i] == 'I') {
				i--;
				continue;
			}
		}
		return code;
	}
	
	public void run() {
		int space = KeyEvent.VK_SPACE;
		int i = 0;
		while (i < 200) {
			int[] key = comKey(2);
			keyTyped(key);
			keyTyped(KeyEvent.VK_SPACE);
			i++;
			if (i % 50 == 0) {
				keyTyped(KeyEvent.VK_ENTER);
			}
		}
		keyTyped(space);
	}
	
	public static void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		sleep(2000);
		new TypeRobot().run();
		/**
		 *  
		 */
	}
}
