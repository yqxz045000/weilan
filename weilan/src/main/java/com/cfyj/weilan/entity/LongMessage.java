package com.cfyj.weilan.entity;

/**
 * 
 * @author cfyj
 * 2017年11月11日 下午5:35:42
 * 长文,将内容和基本信息分离
 *
 */
public class LongMessage extends BaseEntity{
	
	private static final long serialVersionUID = 7974845329487707590L;
	private Integer id; 
	private Integer userId;				//	用户id
	private Integer categoryId; 		//	类型id
	private String title; 				//	标题
	private Integer contentId;				//	内容
	private String resume ; 			//	概述
	private String bgImg;				//	背景图片，保存地址
	private String status; 				//	状态
	
	private LongMessageContent content; //内容实体

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getContentId() {
		return contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getBgImg() {
		return bgImg;
	}

	public void setBgImg(String bgImg) {
		this.bgImg = bgImg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LongMessageContent getContent() {
		return content;
	}

	public void setContent(LongMessageContent content) {
		this.content = content;
	}
	
}
