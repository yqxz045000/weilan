package com.cfyj.weilan.constant;

/**
 * 定义所有类型的常量，如用户、文章 的状态、删除标记等。
 * @author cfyj
 *2017年12月6日 下午2:01:09
 *
 */
public class Constant {
	
	/**********************status******************************/
	public static final String STATUS_NORMAL = "1"; //正常   ----已处理（对应回复类状态）
	
	public static final String STATUS_ABNORMAL = "10"; //异常 ---- 未处理（对应回复类状态）
	
	public static final String STATUS_FREEZE = "0"; //冻结  ---  异常（对应回复类状态）
	
	/*************************isDelete*********************************/
	
	public static final String DELETE_TRUE = "1";// 标记删除
	
	public static final String DELETE_FALSE = "1";// 标记不删除
	
	

	
	

}
