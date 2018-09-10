package com.lyl.dnf.action.impl;

import com.lyl.dnf.action.Action;
import com.lyl.dnf.util.TypeRobot;
import com.sun.glass.events.KeyEvent;

public class Attack implements Action {

	public void action() {
		TypeRobot.keyTyped(KeyEvent.VK_X);
	}
	
}
