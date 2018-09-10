package com.baidu.aip.ocr;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

public class AipOcrUtils {
	
	private static AipOcr aipOcr;
	
	static {
		aipOcr = new AipOcr(AuthService.APP_ID, AuthService.API_KEY, AuthService.SECRET_KEY);
	}
	
	/**
     * 通用文字识别接口   
     * 用户向服务请求识别某张图中的所有文字
     *
     * @param image - 二进制图像数据
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     *   language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *   detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *   detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *   probability 是否返回识别结果中每一行的置信度
     * @return JSONObject
     */
    public static JSONObject basicGeneral(byte[] image, HashMap<String, String> options) {
    	return aipOcr.basicGeneral(image, options);
    }
    
    /**
     * 通用文字识别接口
     * 用户向服务请求识别某张图中的所有文字
     *
     * @param image - 本地图片路径
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     *   language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *   detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *   detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *   probability 是否返回识别结果中每一行的置信度
     * @return JSONObject
     */
    public static JSONObject basicGeneral(String image, HashMap<String, String> options) {
    	return aipOcr.basicGeneral(image, options);
    }
	
	/**
     * 通用文字识别（高精度版）接口   
     * 用户向服务请求识别某张图中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
     *
     * @param image - 二进制图像数据
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     *   detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *   probability 是否返回识别结果中每一行的置信度
     * @return JSONObject
     */
    public static JSONObject basicAccurateGeneral(byte[] image, HashMap<String, String> options) {
    	return aipOcr.basicAccurateGeneral(image, options);
    }
    
    /**
     * 通用文字识别（高精度版）接口
     * 用户向服务请求识别某张图中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
     *
     * @param image - 本地图片路径
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     *   detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *   probability 是否返回识别结果中每一行的置信度
     * @return JSONObject
     */
    public static JSONObject basicAccurateGeneral(String image, HashMap<String, String> options) {
    	return aipOcr.basicAccurateGeneral(image, options);
    }
    
    /**
     * 通用文字识别（含位置信息版）接口   
     * 用户向服务请求识别某张图中的所有文字，并返回文字在图中的位置信息。
     *
     * @param image - 二进制图像数据
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     *   recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     *   language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *   detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *   detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *   vertexes_location 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     *   probability 是否返回识别结果中每一行的置信度
     * @return JSONObject
     */
	public static JSONObject general(String image, HashMap<String, String> options) {
		return aipOcr.general(image, options);
	}

    /**
     * 通用文字识别（含位置信息版）接口
     * 用户向服务请求识别某张图中的所有文字，并返回文字在图中的位置信息。
     *
     * @param image - 本地图片路径
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     *   recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     *   language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *   detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *   detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *   vertexes_location 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     *   probability 是否返回识别结果中每一行的置信度
     * @return JSONObject
     */
	public static JSONObject general(byte[] image, HashMap<String, String> options) {
		return aipOcr.general(image, options);
	}
	
    /**
     * 通用文字识别（含位置高精度版）接口
     * 用户向服务请求识别某张图中的所有文字，并返回文字在图片中的坐标信息，相对于通用文字识别（含位置信息版）该产品精度更高，但是识别耗时会稍长。
     *
     * @param image - 本地图片路径
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     *   recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     *   detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *   vertexes_location 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     *   probability 是否返回识别结果中每一行的置信度
     * @return JSONObject
     */
	public static JSONObject accurateGeneral(String image, HashMap<String, String> options) {
		return aipOcr.accurateGeneral(image, options);
	}
	
    /**
     * 通用文字识别（含位置高精度版）接口
     * 用户向服务请求识别某张图中的所有文字，并返回文字在图片中的坐标信息，相对于通用文字识别（含位置信息版）该产品精度更高，但是识别耗时会稍长。
     *
     * @param image - 本地图片路径
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     *   recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     *   detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *   vertexes_location 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     *   probability 是否返回识别结果中每一行的置信度
     * @return JSONObject
     */
	public static JSONObject accurateGeneral(byte[] image, HashMap<String, String> options) {
		return aipOcr.accurateGeneral(image, options);
	}
	
    /**
     * 通用文字识别（含生僻字版）接口   
     * 某些场景中，图片中的中文不光有常用字，还包含了生僻字，这时用户需要对该图进行文字识别，应使用通用文字识别（含生僻字版）。
     *
     * @param image - 二进制图像数据
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     *   language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *   detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *   detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *   probability 是否返回识别结果中每一行的置信度
     * @return JSONObject
     */
    public static JSONObject enhancedGeneral(byte[] image, HashMap<String, String> options) {
    	return aipOcr.enhancedGeneral(image, options);
    }
    
    /**
     * 通用文字识别（含生僻字版）接口
     * 某些场景中，图片中的中文不光有常用字，还包含了生僻字，这时用户需要对该图进行文字识别，应使用通用文字识别（含生僻字版）。
     *
     * @param image - 本地图片路径
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     *   language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *   detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *   detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *   probability 是否返回识别结果中每一行的置信度
     * @return JSONObject
     */
    public static JSONObject enhancedGeneral(String image, HashMap<String, String> options) {
    	return aipOcr.enhancedGeneral(image, options);
    }

}
