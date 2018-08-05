package com.cfyj.weilan.utils;

import org.apache.commons.lang3.StringUtils;
import org.owasp.esapi.ESAPI;

/**
 * 预防xxs攻击：
 * 1.使用ESAPI.encoder().encodeForHTML(message.getTitle()) 对内容解析为utf8字符
 * 2.使用replace替换<script> 串
 * @author cfyj
 *2018年1月14日 下午12:58:39
 *
 */
public class XXSUtils {
	
	/**
	 * 使用ESAPI进行编码
	 * @param content
	 * @return
	 */
	public static String esapiEncode(String content) {
		String encodeStr = "";
		if(StringUtils.isNotBlank(content)) {
			encodeStr = ESAPI.encoder().encodeForHTML(content);
		}
		return encodeStr;
	}
	
	/**
	 * 采用替换方式将<script> 替换为script
	 * @return
	 */
	public static  String reEncode(String content) {
		String encodeStr = "";
		if(StringUtils.isNotBlank(content)) {
			encodeStr = content.replaceAll("<script>", "script");
		}
		return encodeStr;
	}
	

}
