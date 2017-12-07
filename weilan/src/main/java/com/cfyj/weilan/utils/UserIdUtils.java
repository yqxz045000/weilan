package com.cfyj.weilan.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * userId随机生成工具
 * @author cfyj
 *2017年12月7日 下午1:25:26
 *
 */
public class UserIdUtils {

//	public static String id_length = "6";
	
	public static final String pre_type = "2";
	private static Map<String,Integer> id_lengthMap = new HashMap<String,Integer>();
	
	static {
		id_lengthMap.put("1", 10000);
		id_lengthMap.put("2", 100000);
		id_lengthMap.put("3", 1000000);
		id_lengthMap.put("4", 10000000);
		id_lengthMap.put("5", 100000000);
	
	}
	
	
	private static Random random1  = new Random();
	private static Random random2  = new Random();
	private static Random random3  = new Random();
	
	/**
	 * 生成id的随机前缀
	 * @return
	 */
	public static  String generatorRandomPre() {		
		return random2.nextInt(UserIdUtils.id_lengthMap.get(UserIdUtils.pre_type))+"";		
	}
	
	public static  int generatorUserId() {
		return random1.nextInt(id_lengthMap.get(random3.nextInt(5)+""));			
	}

}
