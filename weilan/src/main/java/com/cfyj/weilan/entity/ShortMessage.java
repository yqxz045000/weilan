package com.cfyj.weilan.entity;

/**
 * 
 * @author cfyj
 * 2017年11月11日 下午5:28:31
 * 记录用户短文
 *
 */
public class ShortMessage extends BaseEntity{
	
	//TODO 少图片的上传功能
	
	private static final long serialVersionUID = 5258540024400115762L;

	private Integer id;				
	private Integer userId;			//用户id
	private String type;			//字典项 类型,分为M和E
	private Integer categoryId;		//分类id
	private String content;			//用户发表的内容
	private Integer essayId;			// 文章的id 
	private String status; 			//字典项   状态
	
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getEssayId() {
		return essayId;
	}
	public void setEssayId(Integer essayId) {
		this.essayId = essayId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ShortMessage [id=" + id + ", userId=" + userId + ", type=" + type + ", categoryId=" + categoryId
				+ ", content=" + content + ", essayId=" + essayId + ", status=" + status + "]";
	}
	
	
	

}
