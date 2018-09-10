package com.lyl.dnf.entity;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

public class Role {

	private String name;
	
	private Rectangle rectangle;
	
	private List<Skill> skills;
	
	public Point getLocation() {
		return rectangle.getLocation();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
}
