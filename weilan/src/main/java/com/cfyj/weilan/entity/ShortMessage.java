package com.cfyj.weilan.entity;

/**
 * 
 * @author cfyj
 * 2017年11月11日 下午5:28:31
 * 记录用户短文
 *
 */
public class ShortMessage extends BaseEntity{
	
	
	
	private static final long serialVersionUID = 5258540024400115762L;

	private Integer id;				
	private Integer userId;			//用户id
	private String type;			//字典项 类型,分为M和E
	private Integer categoryId;		//分类id
	private String content;			//用户发表的内容
	private Integer essayId;			// 文章的id 
	private String status; 			//字典项   状态
	

}
