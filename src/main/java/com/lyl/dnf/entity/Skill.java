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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + keycode;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		if (keycode != other.keycode)
			return false;
		return true;
	}
}
