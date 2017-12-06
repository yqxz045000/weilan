package com.cfyj.weilan.entity;
/**
 * 分类分为系统分类和用户自定义的分类
 * @author cfyj
 *2017年12月6日 下午2:00:06
 *
 */
public class Category extends BaseEntity  {

	private static final long serialVersionUID = -8732947076915436755L;
	private Integer userId; //用户id
	
	private Integer id;

	private String name; // 分类名称

	private String description; // 描述

	private String status; // 状态

//	private String isDelete; // 删除标记
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Category [userId=" + userId + ", id=" + id + ", name=" + name + ", description=" + description
				+ ", status=" + status + "]";
	}
	
	
	
	
}
