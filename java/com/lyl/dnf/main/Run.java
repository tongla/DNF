package com.lyl.dnf.main;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lyl.common.util.RandomUtils;
import com.lyl.dnf.entity.DNFRole;
import com.lyl.dnf.entity.Skill;

public class Run {
	
	private static DNFRole role;
	
	private static TypeRobot robot = new TypeRobot();
	
	private static ExecutorService brain = Executors.newFixedThreadPool(32);
	
	public static void attack() {
		Skill skill;
		synchronized(role.getSkills()) {
			if (!role.getSkills().isEmpty()) {
				skill = role.getSkills().remove(RandomUtils.randomInt(role.getSkills().size()));
				robot.keyTyped(skill.getKeycode());
				brain.execute(new CDRunnable(skill));
				return;
			}
		}
		robot.keyTyped(KeyEvent.VK_X);
	}

	public static void toPoint(Point point) {
		toPoint(point.x, point.y);
	}
	
	public static void toPoint(int x, int y) {
		Point location = role.getLocation();
		if (location.getX() < x) {
		}
	}
	
	public static class CDRunnable implements Runnable {
		
		public Skill skill;
		
		public CDRunnable(Skill skill) {
			this.skill = skill;
		}

		public void run() {
			sleep(skill.getCdTime());
			synchronized (role.getSkills()) {
				role.getSkills().add(skill);
			}
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
