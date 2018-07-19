package com.lyl.dnf.entity;

import java.util.List;

import com.baidu.aip.entity.Location;

public class Role {

	private String name;
	
	private Location location;
	
	private List<Skill> skills;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
}
