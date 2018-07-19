package com.lyl.dnf.main;

import java.awt.event.KeyEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.baidu.aip.entity.Location;
import com.lyl.common.utils.util.RandomUtils;
import com.lyl.dnf.config.Configuration;
import com.lyl.dnf.entity.Role;
import com.lyl.dnf.entity.Skill;
import com.lyl.dnf.util.TypeRobot;

public class Run {
	
	private static Role role;
	
	private static ParseImage parseImage = new ParseImageImpl();
	
	private static TypeRobot robot = new TypeRobot();
	
	private static ExecutorService brain = Executors.newFixedThreadPool(32);
	
	private static Configuration cfg;
	
	static {
		
		//brain.execute(new RoleLocationRunnable(role));
	}
	
	public static Skill getSkill() {
		synchronized (role.getSkills()) {
			if (!role.getSkills().isEmpty()) { 
				Skill skill = role.getSkills().remove(RandomUtils.randomInt(role.getSkills().size()));
				robot.keyTyped(skill.getKeycode());
				brain.execute(new CDRunnable(skill));
				return skill;
			}
		}
		return normalAttack();
	}
	
	
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
	
	public static Skill normalAttack() {
		Skill skill = new Skill();
		skill.setKeycode(KeyEvent.VK_X);
		skill.setName("普通攻击");
		skill.setCd(200);
		return skill;
	}
	
	// 移动到指定位置
	public static void toLocation(Location location) {
		toLocation(location.getLeft(), location.getTop());
	}
	
	public static void toLocation(int x, int y) {
		while (true) {
			int nx = role.getLocation().getLeft();
			int ny = role.getLocation().getTop();
			if (nx < x && ny < y) {
				robot.rightPress();
				robot.upPress();
			} else if (nx < x && ny > y) {
				robot.rightPress();
				robot.downPress(); 
			} else if (nx > x && ny < y) {
				robot.leftPress();
				robot.upPress();
			} else if (nx > x && ny > y) {
				robot.leftPress();
				robot.downPress();
			} else if (nx > x) {
				robot.leftPress();
			} else if (nx < x) {
				robot.rightPress();
			} else if (ny < y) {
				robot.upPress();
			} else if (ny > y) {
				robot.downPress();
			} else {
				attack();
			}
		}
	}
	
	// 达到目标点
	public static boolean isArrive(Location point) {
		return role.getLocation().getLeft() == point.getLeft() && role.getLocation().getTop() == point.getTop();
	}
	
	// 更新角色所在位置
	public static class RoleLocationRunnable implements Runnable {

		private Role role;
		
		public RoleLocationRunnable(Role role) {
			this.role = role;
		}
		
		public void run() {
			while (true) {
				 Location location = parseImage.getLocation(role.getName(), robot.printScreen(cfg.getDnfWindowLocation()));
				 role.setLocation(location);
				 sleep(300);
			}
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
				if (!role.getSkills().contains(skill)) {
					role.getSkills().add(skill);
				}
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
