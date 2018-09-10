package com.baidu.aip.ocr;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.lyl.common.utils.GsonUtils;
import com.lyl.common.utils.image.ImageUtils;
import com.lyl.common.utils.util.UrlUtils;

public class OcrUtils {
	
	/**
	 * 通用文字识别
	 */
	public static final String GENERAL_BASIC = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic";
	
	/**
	 * 通用文字识别，高精度版
	 */
	public static final String ACCURATE_BASIC = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate_basic";
	
	/**
	 * 通用文字识别，含位置信息
	 */
	public static final String GENERAL = "https://aip.baidubce.com/rest/2.0/ocr/v1/general";
	
	/**
	 * 通用文字识别，高精度，含位置信息
	 */
	public static final String ACCURATE = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate";
	
	/**
	 * 通用文字识别，含生僻字
	 */
	public static final String GENERAL_ENHANCED = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_enhanced";
	
	/**
	 * 网络图片文字识别
	 * - 用户向服务请求识别一些网络上背景复杂，特殊字体的文字。
	 */
	public static final String WEBIMAGE = "https://aip.baidubce.com/rest/2.0/ocr/v1/webimage";
	
	/**
	 * 身份证识别
	 */
	public static final String IDCARD = "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard";
	
	/**
	 * 银行卡识别
	 */
	public static final String BANKCARD = "https://aip.baidubce.com/rest/2.0/ocr/v1/bankcard";
	
	/**
	 * 驾驶证识别
	 */
	public static final String DRIVING_LICENSE = "https://aip.baidubce.com/rest/2.0/ocr/v1/driving_license";
	
	/**
	 * 行驶证识别
	 */
	public static final String VEHICLE_LICENSE = "https://aip.baidubce.com/rest/2.0/ocr/v1/vehicle_license";
	
	/**
	 * 车牌识别
	 */
	public static final String LICENSE_PLATE = "https://aip.baidubce.com/rest/2.0/ocr/v1/license_plate";
  
	/**
	 * 营业执照识别
	 * - 识别营业执照，并返回关键字段的值，包括单位名称、法人、地址、有效期、证件编号、社会信用代码等。
	 * 	log_id	是	uint64	请求标识码，随机数，唯一。
	 * 	words_result_num	是	uint32	识别结果数，表示words_result的元素个数
	 * 	words_result	array()	识别结果数组	
	 * 	left	是	uint32	表示定位位置的长方形左上顶点的水平坐标
	 * 	top	是	uint32	表示定位位置的长方形左上顶点的垂直坐标
	 * 	width	是	uint32	表示定位位置的长方形的宽度
	 * 	height	是	uint32	表示定位位置的长方形的高度
	 * 	words	否	string	识别结果字符串
	 */
	public static final String BUSINESS_LICENSE = "https://aip.baidubce.com/rest/2.0/ocr/v1/business_license";
	
	/**
	 * 表格文字识别
	 * - 自动识别表格线及表格内容，结构化输出表头、表尾及每个单元格的文字内容。
	 *   表格文字识别接口为异步接口，分为两个API：提交请求接口、获取结果接口。下面分别描述两个接口的使用方法。
	 */
	public static final String REQUEST = "https://aip.baidubce.com/rest/2.0/solution/v1/form_ocr/request";
	
	/**
	 * 通用票据识别
	 * - 用户向服务请求识别医疗票据、发票、的士票、保险保单等票据类图片中的所有文字，并返回文字在图中的位置信息。
	 */
	public static final String RECEIPT = "https://aip.baidubce.com/rest/2.0/ocr/v1/receipt";
	
	
	public static final String DEFAULT_ARGS = "fromdevice=pc&clientip=10.10.10.0&detecttype=LocateRecognize&languagetype=CHN_ENG&imagetype=1&image=";
	/**
	 * 测试，正式使用时将auth保存在，过期时在重新获取
	 * @param httpUrl
	 * @param httpArgs
	 * @return
	 */
	public static String request(String httpUrl, String base64) {
		httpUrl += "?access_token="+AuthService.getAccessToken();
		Map<String, String> header = new HashMap<String, String>();
		header.put("Content-Type", "application/x-www-form-urlencoded");
		header.put("apiKey", AuthService.API_KEY);
		System.out.println();
		return UrlUtils.readAsString(httpUrl, DEFAULT_ARGS + base64.replaceAll("\\+", "%2B"), UrlUtils.POST, header);
	}
	
	public static OcrResult requestAsOcrResult(String url, String args) {
		return GsonUtils.jsonToObject(request(url, args), OcrResult.class);
	}
	
}
