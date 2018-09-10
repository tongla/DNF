package com.lyl.dnf.action.impl;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.lyl.dnf.action.Action;
import com.lyl.dnf.entity.Detection;
import com.lyl.dnf.entity.Role;
import com.lyl.dnf.util.DetectionUtils;
import com.lyl.dnf.util.TypeRobot;

public class Move implements Action {

	private Role role;
	
	private Rectangle target;
	
	public Move(Role role, Rectangle target) {
		this.role = role;
		this.target = target;
		BufferedImage image = TypeRobot.printScreen();
		Detection detection = DetectionUtils.detection(image, 0.7);
		detection.getRectangle();
	}
	
	@Override
	public void action() {
		role.getLocation();
	}

}
