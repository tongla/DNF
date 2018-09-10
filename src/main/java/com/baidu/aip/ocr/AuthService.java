package com.baidu.aip.ocr;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

import com.lyl.common.utils.util.UrlUtils;

/**
 * 获取token类
 */
public class AuthService {

	public static final String APP_ID = "10975201";
	
	public static final String API_KEY = "oKSc6uTGUwTukaZcy5ok9NMe";
	
	public static final String SECRET_KEY = "3BBvr86wGQe5xHBsnpRrny5ca9DlrcUI";

	// grant_type为固定参数
	public static final String AUTH_HOST = "https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id="
			+ API_KEY + "&client_secret=" + SECRET_KEY;
	
	private static String accessToken;
	
	private static URL AUTH_URL;
	
	static {
		try {
			AUTH_URL = new URL(AUTH_HOST);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			AUTH_URL = null;
		}
		accessToken = getAuth();
	}

	/**
	 * 获取权限token
	 * 
	 * @return 返回示例： { "access_token":
	 *         "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567",
	 *         "expires_in": 2592000 } 获取API访问token 该token有一定的有效期，需要自行管理，当失效时需重新获取.
	 * 
	 * @param ak
	 *            - 百度云官网获取的 API Key
	 * @param sk
	 *            - 百度云官网获取的 Securet Key
	 * @return assess_token 示例：
	 *         "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567"
	 */
	public static String getAuth() {
		return new JSONObject(UrlUtils.readAsString(AUTH_URL)).getString("access_token");
	}

	public static String getAccessToken() {
		return accessToken;
	}

}