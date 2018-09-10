package com.baidu.aip.ocr;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.ocr.OcrResult.WordResult;
import com.lyl.common.utils.GsonUtils;

public class OcrTest {

	public static void main(String[] args) {
		String image = "D:\\TMP\\QQ图片20180705090316.jpg";
		HashMap<String, String> options = null;
		JSONObject json = AipOcrUtils.basicGeneral(image, options);
		System.out.println(json);
		OcrResult result = GsonUtils.jsonToObject(json.toString(), OcrResult.class);
		foreachWordResult(result);
		image = "D:\\TMP\\QQ图片20180705091501.jpg";
		json = AipOcrUtils.basicGeneral(image, options);
		result = GsonUtils.jsonToObject(json.toString(), OcrResult.class);
		System.out.println();
		foreachWordResult(result);
	}
	
	public static void foreachWordResult(OcrResult result) {
		if (result.getError_code() != null) {
			System.out.println(result.getError_msg() + " : " + result.getError_code());
		}
		for (WordResult word : result.getWords_result()) {
			System.out.println(word.getWords());
		}
	}
}
