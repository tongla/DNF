package com.lyl.common.utils;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

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
	
	public Rectangle detection(BufferedImage image) {
		return null;
	}
	
	
	public static void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
