package com.lyl.dnf.util;

import com.lyl.dnf.entity.Role;

public class RoleUtils {

	public static int getRoleX(Role role) {
		return role.getLocation().x;
	}
	
	public static int getRoleY(Role role) {
		return role.getLocation().y;
	}
	
	public static int getRoleWidth(Role role) {
		return role.getRectangle().width;
	}
	
	public static int getRoleHeight(Role role) {
		return role.getRectangle().height;
	}
	
	/**
	 * 操作
	 */
	
	// 攻击
	public static void attack() {
		
	}
	
}
