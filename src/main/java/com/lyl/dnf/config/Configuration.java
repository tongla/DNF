package com.lyl.dnf.config;
// 配置类

import com.baidu.aip.entity.Location;

public class Configuration {
	
	private String username;

	// qq帐号
	private String qqAccount;
	
	// qq密码
	private String qqPassword;
	
	// DNF 窗口位置
	private Location dnfWindowLocation;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getQqAccount() {
		return qqAccount;
	}

	public void setQqAccount(String qqAccount) {
		this.qqAccount = qqAccount;
	}

	public String getQqPassword() {
		return qqPassword;
	}

	public void setQqPassword(String qqPassword) {
		this.qqPassword = qqPassword;
	}

	public Location getDnfWindowLocation() {
		return dnfWindowLocation;
	}

	public void setDnfWindowLocation(Location dnfWindowLocation) {
		this.dnfWindowLocation = dnfWindowLocation;
	}
	
	
	
	
}
