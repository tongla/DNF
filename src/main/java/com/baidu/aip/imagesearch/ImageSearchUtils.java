package com.baidu.aip.imagesearch;

import java.util.HashMap;

import org.json.JSONObject;

public class ImageSearchUtils {

	private static final AipImageSearch aipImageSearch = new AipImageSearch("11381980", "8ydSKH5pGXWuzY7L6RTFCHGn", "MyBNY1iuucOlZuy3HqOT8INv16i9iQG0");
	
    /**
     * 相同图检索—入库接口   
     * 相同图检索包含入库、检索、删除三个子接口；**在正式使用之前请在[控制台](https://console.bce.baidu.com/ai/#/ai/imagesearch/overview/index)创建应用后，在应用详情页申请建库，建库成功后方可正常使用入库、检索、删除三个接口**。
     *
     * @param image - 二进制图像数据
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     *   brief 检索时原样带回,最长256B。
     * @return JSONObject
     */
    public static JSONObject sameHqAdd(byte[] image, HashMap<String, String> options) {
    	return aipImageSearch.sameHqAdd(image, options);
    }
    
    /**
     * 相同图检索—入库接口
     * 相同图检索包含入库、检索、删除三个子接口；**在正式使用之前请在[控制台](https://console.bce.baidu.com/ai/#/ai/imagesearch/overview/index)创建应用后，在应用详情页申请建库，建库成功后方可正常使用入库、检索、删除三个接口**。
     *
     * @param image - 本地图片路径
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     *   brief 检索时原样带回,最长256B。
     * @return JSONObject
     */
    public static JSONObject sameHqAdd(String image, HashMap<String, String> options) {
    	return aipImageSearch.sameHqAdd(image, options);
    }
	
}
