package com.lyl.dnf.entity;

import java.io.Serializable;

public class Skill implements Serializable {
	
	private static final long serialVersionUID = -8915883710810046693L;

	private String name;

	private double cd;
	
	private int keycode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getCd() {
		return cd;
	}

	public void setCd(double cd) {
		this.cd = cd;
	}
	
	public int getCdTime() {
		return (int) (cd * 1000);
	}

	public int getKeycode() {
		return keycode;
	}

	public void setKeycode(int keycode) {
		this.keycode = keycode;
	}
	
}
