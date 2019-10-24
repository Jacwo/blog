package com.yyl.blog.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;

public class HttpClientUtil {

	protected final static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

	public static final String METHOD_POST = "POST";
	public static final String METHOD_GET = "GET";

	private static Map<String, String> cookieMap = new HashMap<String, String>();
	public static String getAddresses(String content){
		//调用淘宝API
		String urlStr = "http://ip.taobao.com/service/getIpInfo2.php?ip="+content;
		String returnStr = doGet(urlStr,300);
		if(returnStr != null){
			System.out.println(returnStr);
			return  returnStr;
		}
		return null;
	}


	/**
	 * 网络请求
	 */
	public static String getHttpContent(String url, String method, String postData, Map<String, String> header, int timeout) {
		return getHttpContent(url, method, postData, header, timeout, timeout);
	}

	/**
	 * 网络请求
	 */
	public static String getHttpContent(
			String url, String method, 
			String postData, Map<String, String> header, 
			int connectTimeout, int readTimeout) {

		BufferedReader reader = null;
		try {
			if (StringUtils.isBlank(url)) {
				throw new IllegalArgumentException("url cannot be null");
			}
			if (!METHOD_POST.equalsIgnoreCase(method) && !METHOD_GET.equalsIgnoreCase(method)) {
				throw new IllegalArgumentException("method must be one of Post or Get");
			}
			URL address = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) address.openConnection();
			conn.setAllowUserInteraction(false);
			conn.setDoOutput(true);
			conn.setConnectTimeout(connectTimeout);
			conn.setReadTimeout(readTimeout);
			conn.setRequestMethod(method);
			conn.setUseCaches(false);

			Map<String, String> defaultHeader = new HashMap<String, String>();
			defaultHeader.put("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2;SV1)");
			defaultHeader.put("Accept", "*/*");
			defaultHeader.put("Connection", "Keep-Alive");
			defaultHeader.put("Content-Type", "application/xml; charset=utf-8");
			if (header != null && !header.isEmpty()) {
				Set<String> key = header.keySet();
				for (Iterator<String> it = key.iterator(); it.hasNext();) {
					String s = (String) it.next();
					defaultHeader.put(s, (String) header.get(s));
				}
			}
			Set<String> key = defaultHeader.keySet();
			for (Iterator<String> it = key.iterator(); it.hasNext();) {
				String s = (String) it.next();
				conn.addRequestProperty(s, (String) defaultHeader.get(s));
			}
			//传递Cookie
			List<String> lstCookie = new ArrayList<String>();
			for (Entry<String, String> entry : cookieMap.entrySet()) {
				lstCookie.add(String.format("%s=%s", entry.getKey(), entry.getValue()));
			}
			String cookieString = StringUtils.join(lstCookie.toArray(), "; ");
			conn.addRequestProperty("Cookie", cookieString);
//			logger.debug("Cookie:" + cookieString);
			if (METHOD_POST.equalsIgnoreCase(method)) {
				postData = StringUtils.trimToEmpty(postData);
				conn.getOutputStream().write(postData.getBytes("UTF-8"));
				conn.getOutputStream().flush();
				conn.getOutputStream().close();
			}

			//获取Cookie
			for (Entry<String, List<String>> entry : conn.getHeaderFields().entrySet()) {
				if (StringUtils.equalsIgnoreCase(entry.getKey(), "set-cookie")) {
					for (String cookie : entry.getValue()) {
						if (cookie.indexOf(';') != -1) {
							cookie = cookie.substring(0, cookie.indexOf(';'));
						}
						String[] tokens = cookie.split("=");
						cookieMap.put(tokens[0], tokens[1]);
					}
				}
			}

			reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			StringBuffer sb = new StringBuffer();
			String inputLine;
			while ((inputLine = reader.readLine()) != null) {
				sb.append(inputLine).append("\n");
			}
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(), e);
		} catch (RuntimeException e) {
			throw e;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static String doGet(String url, int timeout) {
		return getHttpContent(url, METHOD_GET, null, null, timeout);
	}

	public static String doPost(String url, String postData, int timeout) {
		return getHttpContent(url, METHOD_POST, postData, null, timeout);
	}

	/**
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Map<String, String> header = new Hashtable<String, String>();
		// String url =
		// "http://test.1jiankang.com/api/order/notify-order-picking-status";
		// String url =
		// "http://test.1jiankang.com/api/order/notify-order-goods-returned";


		/*String url = "http://test.1jiankang.com/api/stock/get-stock";
		String postData = "{\"orderNumber\": \"1_123456\"}";
		// String s = HttpClientUtil.doPost(url, postData, 2000);*/
		String s = getAddresses("180.167.88.42");
		System.out.println(s);
	}
}