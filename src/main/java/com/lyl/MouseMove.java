package com.lyl;

import java.awt.AWTException;
import java.awt.Robot;

import com.lyl.dnf.util.TypeRobot;

public class MouseMove {

	public static TypeRobot typeRobot = new TypeRobot();
	
	public static Robot robot;
	
	static {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
