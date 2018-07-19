package com.lyl.dnf.entity;

import java.awt.Point;
import java.util.List;

public class DNFRole {

	private String name;
	
	private Point location;
	
	private List<Skill> skills;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
}
