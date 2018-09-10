package com.baidu.aip.image;

import java.io.Serializable;
import java.util.List;

import com.baidu.aip.entity.Location;

public class ImageResult implements Serializable {

	private static final long serialVersionUID = 9101107347014446928L;

	private long log_id;

	private int result_num;
	
	private List<Result> resultList;
	
	private Location result;
	
	public static class Result {
		private Double score;

		private String root;

		private String keyword;

		public Double getScore() {
			return score;
		}

		public void setScore(Double score) {
			this.score = score;
		}

		public String getRoot() {
			return root;
		}

		public void setRoot(String root) {
			this.root = root;
		}

		public String getKeyword() {
			return keyword;
		}

		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}
		
		@Override
		public String toString() {
			return "{score : " + score + ", root : " + root + ", keyword : "	 + keyword+"}";
		}

	}

	public long getLog_id() {
		return log_id;
	}

	public void setLog_id(long log_id) {
		this.log_id = log_id;
	}

	public int getResult_num() {
		return result_num;
	}

	public void setResult_num(int result_num) {
		this.result_num = result_num;
	}

	public List<Result> getResultList() {
		return resultList;
	}

	public void setResultList(List<Result> resultList) {
		this.resultList = resultList;
	}

	public Location getResult() {
		return result;
	}

	public void setResult(Location result) {
		this.result = result;
	}
	
}
