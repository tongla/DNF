package com.lyl.dnf.entity;

import java.awt.Rectangle;

public class Detection {

	/**
	 * 类型
	 */
	private Integer classes;
	
	/**
	 * 位置
	 */
	private Rectangle rectangle;
	
	/**
	 * 几率
	 */
	private Double sources;

	public Integer getClasses() {
		return classes;
	}

	public void setClasses(Integer classes) {
		this.classes = classes;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public Double getSources() {
		return sources;
	}

	public void setSources(Double sources) {
		this.sources = sources;
	}
	
}
