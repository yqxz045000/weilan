package com.cfyj.weilan.constant;

import java.util.HashSet;
import java.util.Set;

/**
 * 在判断路径时：对比的是不过滤路径，其他路径为需要登录后才能访问的路径
 * @author cfyj
 *2017年12月4日 下午4:24:14
 *
 */
public class URLConstant {
	
	public static Set<String> no_filter_userUrl = new HashSet<String>();

	/**
	 * User的不过滤路径
	 */
	static {
		no_filter_userUrl.add("");
	}
	
}
