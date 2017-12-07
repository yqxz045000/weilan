package com.cfyj.weilan.domain.query;

import com.cfyj.weilan.domain.Page;

public class ShortMessageQuery extends Page{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6181988339829534822L;
	
		
	private Integer userId;			//用户id
	private String type;			//字典项 类型,分为M和E
	private Integer categoryId;		//分类id
	
	private String beginTime;		//开始时间
	private String endTime;			//结束时间
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
