package com.baidu.aip.ocr;

import java.io.Serializable;
import java.util.List;

import com.baidu.aip.entity.Location;

public class OcrResult implements Serializable {

	private static final long serialVersionUID = -2975669850036989086L;

	private String log_id;
	
	/**
	 * 返回的几行数据
	 */
	private String words_result_num;
	
	/**
	 * 识别的结果
	 */
	private List<WordResult> words_result;
	
	
	/**
	 * 错误消息
	 */
	private String error_msg;
	
	/**
	 * 错误代码, 含义要到百度云查询
	 */
	private String error_code;
	
	public String getLog_id() {
		return log_id;
	}

	public void setLog_id(String log_id) {
		this.log_id = log_id;
	}

	public String getWords_result_num() {
		return words_result_num;
	}

	public void setWords_result_num(String words_result_num) {
		this.words_result_num = words_result_num;
	}

	public List<WordResult> getWords_result() {
		return words_result;
	}

	public void setWords_result(List<WordResult> words_result) {
		this.words_result = words_result;
	}

	public String getError_msg() {
		return error_msg;
	}

	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	
	public static class WordResult {
		
		private Location location;
		
		private String words;

		public String getWords() {
			return words;
		}

		public void setWords(String words) {
			this.words = words;
		}
		
		@Override
		public String toString() {
			return location + " " + words;
		}

		public Location getLocation() {
			return location;
		}

		public void setLocation(Location location) {
			this.location = location;
		}
		
	}
	
}
