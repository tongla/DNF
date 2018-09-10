package com.lyl.dnf.util;

import com.lyl.dnf.entity.Role;

public class RoleUtils {

	public static int getRoleX(Role role) {
		return role.getLocation().getLeft();
	}
	
	public static int getRoleY(Role role) {
		return role.getLocation().getTop();
	}
	
	public static int getRoleWidth(Role role) {
		return role.getLocation().getWidth();
	}
	
	public static int getRoleHeight(Role role) {
		return role.getLocation().getHeight();
	}
	
	/**
	 * 操作
	 */
	
	// 攻击
	public static void attack() {
		
	}
	
}
