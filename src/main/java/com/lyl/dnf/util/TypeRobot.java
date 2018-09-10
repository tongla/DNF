package com.lyl.dnf.util;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class TypeRobot {
	
	private static Robot robot;
	
	static {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public static void keyTyped(int...keycodes) {
		for (int keycode : keycodes) {
			robot.keyPress(keycode);
			robot.keyRelease(keycode);
		}
	}
	
	public static void keyDownRelease(int...keycodes) {
		for (int keycode : keycodes) {
			robot.keyPress(keycode);
		}
		for (int keycode : keycodes) {
			robot.keyRelease(keycode);
		}
	}
	
	public static void leftPress() {
		robot.keyPress(KeyEvent.VK_LEFT);
	}
	
	public static void leftRelease() {
		robot.keyRelease(KeyEvent.VK_LEFT);
	}
	
	public static void rightPress() {
		robot.keyPress(KeyEvent.VK_RIGHT);
	}
	
	public static void rightRelease() {
		robot.keyRelease(KeyEvent.VK_RIGHT);
	}
	
	public static void upPress() {
		robot.keyPress(KeyEvent.VK_UP);
	}
	
	public static void upRelease() {
		robot.keyRelease(KeyEvent.VK_UP);
	}
	
	public static void downPress() {
		robot.keyPress(KeyEvent.VK_DOWN);
	}
	
	public static void downRelease() {
		robot.keyRelease(KeyEvent.VK_DOWN);
	}
	
	public static BufferedImage printScreen() {
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		return robot.createScreenCapture(screenRect);
	}
	
	public static BufferedImage printScreen(Rectangle rectangle) {
		 return robot.createScreenCapture(rectangle);
	}
	
	public static BufferedImage printScreen(int x, int y, int width, int height) {
		Rectangle screenRect = new Rectangle(x, y, width, height);
		return robot.createScreenCapture(screenRect);
	}
	
	public static Point getMouseLocation() {
		return MouseInfo.getPointerInfo().getLocation();
	}
	
	public static void mouseMove(int x, int y) {
		mouseMove(new Point(x, y));
	}
	
	public static void mouseMove(Point point) {
		mouseMove(point, 1);
	}
	
	public static void mouseMove(Point point, long lazyMillis) {
		Point location;
		do {
			location = getMouseLocation();
			if (location.x < point.x && location.y < point.y) 
				robot.mouseMove(location.x+1, location.y+1);
			else if (location.x < point.x && location.y > point.y)
				robot.mouseMove(location.x+1, location.y-1);
			else if (location.x > point.x && location.y < point.y)
				robot.mouseMove(location.x-1, location.y+1);
			else if (location.x > point.x && location.y > point.y) 
				robot.mouseMove(location.x-1, location.y-1);
			else if (location.x < point.x)
				robot.mouseMove(location.x+1, location.y);
			else if(location.x > point.x) 
				robot.mouseMove(location.x-1, location.y);
			else if(location.y < point.y) 
				robot.mouseMove(location.x, location.y+1);
			else if (location.y > point.y)
				robot.mouseMove(location.x, location.y-1);
			if (lazyMillis > 0) {
				long now = System.currentTimeMillis();
				while((System.currentTimeMillis() - now) < lazyMillis);
			}
		} while(!point.equals(location));
	}
	
}
