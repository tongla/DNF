package com.baidu.aip.entity;

import java.io.Serializable;

public class Location implements Serializable {

	private static final long serialVersionUID = -8696329521993512225L;

	private Integer width;
	
	private Integer top;
	
	private Integer height;
	
	private Integer left;
	
	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getTop() {
		return top;
	}

	public void setTop(Integer top) {
		this.top = top;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getLeft() {
		return left;
	}

	public void setLeft(Integer left) {
		this.left = left;
	}
	
	@Override
	public String toString() {
		return "width: " + width + ", left: " + left + ", top: " + top + ", height: " + height;
	}
	
}
