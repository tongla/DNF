package com.lyl.dnf.util;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.baidu.aip.entity.Location;

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
	
	public void leftPress() {
		robot.keyPress(KeyEvent.VK_LEFT);
	}
	
	public void leftRelease() {
		robot.keyRelease(KeyEvent.VK_LEFT);
	}
	
	public void rightPress() {
		robot.keyPress(KeyEvent.VK_RIGHT);
	}
	
	public void rightRelease() {
		robot.keyRelease(KeyEvent.VK_RIGHT);
	}
	
	public void upPress() {
		robot.keyPress(KeyEvent.VK_UP);
	}
	
	public void upRelease() {
		robot.keyRelease(KeyEvent.VK_UP);
	}
	
	public void downPress() {
		robot.keyPress(KeyEvent.VK_DOWN);
	}
	
	public void downRelease() {
		robot.keyRelease(KeyEvent.VK_DOWN);
	}
	
	public BufferedImage printScreen() {
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		return robot.createScreenCapture(screenRect);
	}
	
	public BufferedImage printScreen(Rectangle rectangle) {
		 return robot.createScreenCapture(rectangle);
	}
	
	public BufferedImage printScreen(int x, int y, int width, int height) {
		Rectangle screenRect = new Rectangle(x, y, width, height);
		return robot.createScreenCapture(screenRect);
	}
	
	public BufferedImage printScreen(Location location) {
		return printScreen(location.getLeft(), location.getTop(), location.getWidth(), location.getHeight());
	}
	
}
